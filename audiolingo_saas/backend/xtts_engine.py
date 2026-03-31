import requests

def generate_voice(text):

    response = requests.post(
        "http://127.0.0.1:1234/xtts",
        json={
            "text": text,
            "speaker": "fr_male_1",
            "emotion": "excited"
        }
    )

    with open("voice.wav", "wb") as f:
        f.write(response.content)

    return "voice.wav"