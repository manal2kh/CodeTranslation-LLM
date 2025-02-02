import os
import openai
import shutil
import subprocess
import logging
from dotenv import load_dotenv
from tqdm import tqdm


load_dotenv()
openai.api_key = os.getenv("OPENAI_API_KEY")
TEMPERATURE = 0.8

DATASET_BASE: str = os.path.join(os.getcwd(), "dataset")

input_dir = os.path.join(DATASET_BASE, "codenet", "Java", "code")
refactored_dir = os.path.join(DATASET_BASE, "codenet", "refactored")
output_dir = os.path.join(DATASET_BASE, "codenet", "translated")
testcase_directory = os.path.join(DATASET_BASE, "codenet", "Java", "TestCases")

log_file = os.path.join(DATASET_BASE, "logs", "log_file.log")
if os.path.exists(log_file):
    os.remove(log_file)

os.makedirs(os.path.dirname(log_file), exist_ok=True)
logging.basicConfig(filename=log_file, level=logging.INFO, format="%(message)s")
logger = logging.getLogger()

def refactor_java_code(java_code):
    response = openai.ChatCompletion.create(
        model="gpt-4",
        temperature=TEMPERATURE,
        messages=[
            {"role": "system", "content": "You will be given a code, and asked to do code refactoring. Give only the refactored code without any Markdown and explanations."},
            {"role": "user", "content": f"Please refactor the following Java code without any Markdown and explanations.:\n{java_code}"}
        ]
    )
    return response['choices'][0]['message']['content'].strip()

def translate_code(source_code, source_lang, target_lang):
    response = openai.ChatCompletion.create(
        model="gpt-4",
        temperature=TEMPERATURE,
        messages=[
            {"role": "system", "content": f"You are a helpful assistant for translating code from {source_lang} to {target_lang}."},
            {"role": "user", "content": f"Please translate the following code from {source_lang} into {target_lang} and do not include any Markdown and only print a pure code response:\n{source_code}."}
        ]
    )
    return response['choices'][0]['message']['content'].strip()

def clear_and_recreate_dir(directory):
    if os.path.exists(directory):
        shutil.rmtree(directory)
    os.makedirs(directory, exist_ok=True)

def compare_files(expected_file, actual_output):
    try:
        with open(expected_file, 'r') as f:
            expected_output = f.read().strip()
        return expected_output == actual_output.strip()
    except Exception as e:
        logger.error(f"Error reading file {expected_file}: {e}")
        return False

def test_translations():
    logger.info("\nStarting Testing Phase...\n")
    try:
        input_files = [f for f in os.listdir(testcase_directory) if f.endswith("_in.txt")]
        input_files = list(set(input_files))

        for input_file in input_files:
            output_file = input_file.replace("_in.txt", "_out.txt")
            output_file_path = os.path.join(testcase_directory, output_file)

            cpp_file = input_file.replace("_in.txt", ".cpp")
            cpp_file_path = os.path.join(output_dir, cpp_file)

            if not os.path.exists(cpp_file_path):
                logger.info(f"FAIL: {cpp_file} - C++ file not found.")
                continue

            try:
                compile_process = subprocess.run(
                    ["g++", "-std=c++11", cpp_file_path, "-o", "/tmp/test_program"],
                    capture_output=True, text=True
                )
                if compile_process.returncode != 0:
                    logger.info(f"FAIL: {cpp_file} - Compilation error: {compile_process.stderr}")
                    continue
            except subprocess.CalledProcessError as e:
                logger.info(f"FAIL: {cpp_file} - Compilation error: {e.stderr}")
                continue

            try:
                with open(os.path.join(testcase_directory, input_file), 'r') as infile:
                    run_process = subprocess.run(
                        ["/tmp/test_program"], input=infile.read(), text=True, capture_output=True
                    )

                actual_output = run_process.stdout
                is_equal = compare_files(output_file_path, actual_output)

                if is_equal:
                    logger.info(f"PASS: {cpp_file} - Output matches")
                else:
                    logger.info(f"FAIL: {cpp_file} - Output mismatch")

            except subprocess.CalledProcessError as e:
                logger.info(f"FAIL: {cpp_file} - Runtime error: {e}")

    except Exception as e:
        logger.error(f"FAIL: Error during testing process: {e}")

def main():
    clear_and_recreate_dir(refactored_dir)
    clear_and_recreate_dir(output_dir)

    java_files = [f for f in os.listdir(input_dir) if f.endswith('.java')]

    if not java_files:
        print("\nNo Java files found in 'input_codes'. Exiting...\n")
        return

    print("\nStarting Java Code Refactoring...\n")
    logger.info("\nStarting Java Code Refactoring...\n")

    for filename in tqdm(java_files, desc="Refactoring files", unit="file"):
        with open(os.path.join(input_dir, filename), 'r', encoding='utf-8') as file:
            java_code = file.read()

        refactored_code = refactor_java_code(java_code)

        with open(os.path.join(refactored_dir, filename), 'w', encoding='utf-8') as file:
            file.write(refactored_code)

    print("\nRefactoring completed.\n")
    logger.info("\nRefactoring completed.\n")

    refactored_files = [f for f in os.listdir(refactored_dir) if f.endswith('.java')]
    source_lang = "Java"
    target_lang = "C++"

    if not refactored_files:
        print("\nNo refactored Java files found. Exiting...\n")
        return

    print("\nStarting Java to C++ Translation...\n")
    logger.info("\nStarting Java to C++ Translation...\n")

    for filename in tqdm(refactored_files, desc="Translating files", unit="file"):
        with open(os.path.join(refactored_dir, filename), 'r', encoding='utf-8') as file:
            java_code = file.read()

        translated_code = translate_code(java_code, source_lang, target_lang)

        translated_filename = filename.replace('.java', '.cpp')
        with open(os.path.join(output_dir, translated_filename), 'w', encoding='utf-8') as file:
            file.write(translated_code)

    print("\nTranslation completed.\n")
    logger.info("\nTranslation completed.\n")

    test_translations()

if __name__ == "__main__":
    main()

