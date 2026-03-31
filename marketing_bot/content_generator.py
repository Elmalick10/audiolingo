import requests
import os

TEXT = "Gagner de l'argent avec l'IA en 2026"

# 🎙️ TTS (API locale ou OpenRouter)
def generate_voice(text):
    url = "http://127.0.0.1:1234/tts"

    response = requests.post(url, json={"text": text})
    
    with open("voice.wav", "wb") as f:
        f.write(response.content)

# 🎬 Génération vidéo simple (ffmpeg)
def generate_video():
    os.system("""
    ffmpeg -loop 1 -i bg.jpg -i voice.wav \
    -c:v libx264 -t 10 -pix_fmt yuv420p output.mp4
    """)

generate_voice(TEXT)
generate_video()

print("✅ Vidéo générée automatiquement")