import requests

def generate_avatar(image, audio):

    res = requests.post(
        "https://api.runpod.ai/...",
        json={"image": image, "audio": audio}
    )

    return res.json()