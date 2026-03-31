from audio_live import tts_live
from avatar_engine import generate_avatar
import time

texts = [
    "Bienvenue sur mon live",
    "Abonne-toi maintenant",
    "Nouvelle vidéo incroyable"
]

while True:

    for text in texts:

        tts_live(text)
        generate_avatar("user1")

        print("🎥 Live IA actif")

        time.sleep(5)