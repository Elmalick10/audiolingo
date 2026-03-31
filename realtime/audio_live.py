import sounddevice as sd
from scipy.io.wavfile import write

fs = 44100

def record_audio():
    print("🎙️ Enregistrement...")
    audio = sd.rec(int(3 * fs), samplerate=fs, channels=1)
    sd.wait()

    path = "C:\\audiolingo\\temp\\audio.wav"
    write(path, fs, audio)

    return path

def tts_live(text):

    import requests

    r = requests.post(
        "http://127.0.0.1:1234/tts",
        json={"text": text}
    )

    path = "C:\\audiolingo\\temp\\audio.wav"

    with open(path, "wb") as f:
        f.write(r.content)

    return path