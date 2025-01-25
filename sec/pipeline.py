import subprocess


print("Starting refactoring process ...")
subprocess.run(['python', 'refactoring.py'])


print("Starting translation process ...")
subprocess.run(['python', 'CodeTranslationLLM.py'])

print("Pipeline completed successfully!")

