from audio_live import record_audio
from avatar_engine import generate_avatar

while True:

    audio = record_audio()

    video = generate_avatar()

    print("🎥 Avatar mis à jour")

    