import os
import openai
from dotenv import load_dotenv
from tqdm import tqdm

# Load the .env file to get the OpenAI API key
load_dotenv()
openai.api_key = os.getenv("OPENAI_API_KEY")

# Function to refactor Java code using GPT-4 without additional comments
def refactor_java_code(java_code):
    response = openai.ChatCompletion.create(
        model="gpt-4",
        messages=[
            {"role": "system", "content": " refactoring Java code without adding any comments or explanations."},
            {"role": "user", "content": f"Please refactor the following Java code without adding any comments:\n{java_code}"}
        ]
    )
    return response['choices'][0]['message']['content']

# Directory containing input Java files
input_dir = 'input_codes'
# Directory to save refactored code
output_dir = 'refactored_codes'

# Create the output directory if it doesn't exist
os.makedirs(output_dir, exist_ok=True)

# Get list of Java files in the input directory
java_files = [f for f in os.listdir(input_dir) if f.endswith('.java')]

# Iterate over all Java files in the input directory with progress bar
for filename in tqdm(java_files, desc="Processing files", unit="file"):
    with open(os.path.join(input_dir, filename), 'r') as file:
        java_code = file.read()

    # Refactor the Java code without additional comments
    refactored_code = refactor_java_code(java_code)

    # Save the refactored code to the output directory
    with open(os.path.join(output_dir, filename), 'w') as file:
        file.write(refactored_code)

print("Refactoring completed. Check the 'refactored_codes' directory for results.")
