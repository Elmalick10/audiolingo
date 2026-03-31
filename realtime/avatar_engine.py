import os

def generate_avatar():

    face = "C:\\audiolingo\\temp\\frame.jpg"
    audio = "C:\\audiolingo\\temp\\audio.wav"
    output = "C:\\audiolingo\\output\\live.mp4"

    # image → mini vidéo
    os.system(f"""
    ffmpeg -loop 1 -i "{face}" -t 3 -pix_fmt yuv420p temp.mp4
    """)

    # lipsync
    os.system(f"""
    cd C:\\audiolingo\\ai\\wav2lip && python inference.py ^
    --checkpoint_path wav2lip_gan.pth ^
    --face temp.mp4 ^
    --audio {audio} ^
    --outfile {output}
    """)

    return output

def generate_avatar(user_id):

    base = f"C:\\audiolingo\\avatars\\{user_id}\\"

    face = base + "face.jpg"
    audio = base + "voice.wav"
    output = base + "live.mp4"

    # traitement IA ici

    return output