import subprocess

class Wav2LipEngine:

    def generate(self, face, audio):

        command = [
            "python",
            "inference.py",
            "--checkpoint_path", "models/wav2lip.pth",
            "--face", face,
            "--audio", audio
        ]

        subprocess.run(command)

        return "results/result.mp4"