import os

def text_to_speech(text: str):

    output_path = f"outputs/{text}.txt"

    os.makedirs("outputs", exist_ok=True)

    with open(output_path, "w") as f:
        f.write(text)

    return output_path