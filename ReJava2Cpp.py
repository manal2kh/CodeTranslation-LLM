'''This code is to translate a refactored Java code into C++.'''

import os, shutil
from openai import OpenAI
from dotenv import load_dotenv
from tqdm import tqdm

SOURCE_LANGUAGE:str = "Java"
TARGET_LANGUAGE:str = "C++"
TEMPERATURE = 0.8

# datasets
DATASET_BASE:str = "datasets" + os.sep + "avatar" + os.sep + "Refactored"
#DATASET_BASE:str = "datasets" + os.sep + "codenet" + os.sep + "Refactored"
#DATASET_BASE:str = "datasets" + os.sep + "evalplus" + os.sep + "Refactored"

# set output folder
OUTPUT_DIR:str = os.path.join(DATASET_BASE, "Translated")

def translate_code(client, source_code):
    response = client.chat.completions.create(
        model="gpt-4o-mini",
        messages=[ {"role": "user", "content": f"Please translate the following code from {SOURCE_LANGUAGE} into {TARGET_LANGUAGE} and do not include any Markdown and only print a pure code response:\n{source_code}."} ],
        temperature = TEMPERATURE
        
    )
    
    return response.choices[0].message.content.strip()

def main():
    # Load the .env file to get the OpenAI API key
    load_dotenv()
    client = OpenAI(api_key = os.getenv("OPENAI_API_KEY"))

    if os.path.exists(OUTPUT_DIR): shutil.rmtree(OUTPUT_DIR)
    os.makedirs(OUTPUT_DIR)

    list_files = []
    for root, dirs, files in os.walk(DATASET_BASE):
        for f in files:
            filepath = os.path.join(root, f)
            if filepath.endswith(".java"): list_files.append(filepath)
            
    # TODO: record overall time starting here
    for f in list_files: 
        with open(f, 'r', encoding='utf-8') as file: code = file.read()
        
        # TODO: record specific time starting here
        new_code = translate_code(client, code)
        
        end = f.rindex(os.sep)
        subdirs = f[0:end]
        filename = f[end+1:]
        filename = filename.replace('.java', '.cpp')
        output = os.path.join(OUTPUT_DIR, subdirs)
        os.makedirs(output, exist_ok=True)
        
        # TODO: record specific ending time here
        with open(os.path.join(output, filename), 'w', encoding='utf-8') as file: file.write(new_code)
        
    # TODO: record overall end time here
    print(F"Translation completed. Check the {OUTPUT_DIR} directory for the output code.")

if __name__ == "__main__": main()
