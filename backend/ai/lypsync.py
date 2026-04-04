import subprocess

def generate_video(face, audio):
    output = "result.mp4"

    subprocess.run([
        "python", "Wav2Lip/inference.py",
        "--face", face,
        "--audio", audio,
        "--outfile", output
    ])

    return output