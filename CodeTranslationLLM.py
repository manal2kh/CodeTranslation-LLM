import os
import openai
from dotenv import load_dotenv
from tqdm import tqdm  

# Load the .env file to get the OpenAI API key
load_dotenv()
openai.api_key = os.getenv("OPENAI_API_KEY")

# Function to translate code from one language to another using GPT-4
def translate_code(source_code, source_lang, target_lang):
    response = openai.ChatCompletion.create(
        model="gpt-4",
        messages=[
            {"role": "system", "content": f"You are a helpful assistant for translating code from {source_lang} to {target_lang}."},
            {"role": "user", "content": f"Please translate the following {source_lang} code to {target_lang}:\n{source_code}"}
        ]
    )
    return response['choices'][0]['message']['content']

# Directory containing refactored Java files
input_dir = 'refactored_codes'
# Directory to save translated code
output_dir = 'output_codes'

# Create the output directory if it doesn't exist
os.makedirs(output_dir, exist_ok=True)

# Get list of Java files in the input directory
refactored_files = [f for f in os.listdir(input_dir) if f.endswith('.java')]

# Specify the source and target languages
source_lang = "Java"
target_lang = "C++"

# Iterate over all refactored files in the input directory with progress bar
for filename in tqdm(refactored_files, desc="Processing files", unit="file"):
    with open(os.path.join(input_dir, filename), 'r', encoding='utf-8') as file:
        java_code = file.read()


    translated_code = translate_code(java_code, source_lang, target_lang)

    # Save the translated code to the output directory
    translated_filename = filename.replace('.java', f'.{target_lang.lower()}')  # Change the extension to target language
    with open(os.path.join(output_dir, translated_filename), 'w', encoding='utf-8') as file:
        file.write(translated_code)

print("Translation completed. Check the 'output_codes' directory for results.")
