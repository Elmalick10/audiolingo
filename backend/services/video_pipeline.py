from services.wav2lip import run_wav2lip
from services.sadtalker import run_sadtalker

def generate_video(image, audio, output):

    # 1. Animation visage (SadTalker)
    animated = run_sadtalker(image, audio)

    # 2. Lip sync réaliste (Wav2Lip)
    final = run_wav2lip(animated, audio, output)

    return final