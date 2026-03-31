from brain import generate_content
from moderation import validate_content
from approval import approve
from avatar_engine import generate_avatar
from audio_live import tts_live

prompts = [
    "histoire inspirante",
    "leçon de vie",
    "fait incroyable",
    "motivation quotidienne"
]

def generate_100_videos():

    for i in range(100):

        prompt = prompts[i % len(prompts)]

        content = generate_content(prompt)

        if not validate_content(content):
            print("❌ Contenu rejeté")
            continue

        if not approve(content):
            print("⏭️ Refusé par humain")
            continue

        tts_live(content)
        generate_avatar("user1")

        print(f"🎬 Vidéo {i+1} générée")