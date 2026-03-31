import os

def generate_video(topic):

    text = f"{topic} en 30 secondes 🚀"

    # 🎙️ voix (ton API locale)
    os.system(f'curl -X POST http://127.0.0.1:1234/tts -d "text={text}" -o voice.wav')

    # 🎬 vidéo
    os.system("""
    ffmpeg -loop 1 -i bg.jpg -i voice.wav \
    -vf "drawtext=text='IA':x=10:y=10" \
    -t 10 -pix_fmt yuv420p output.mp4
    """)

    return "output.mp4"