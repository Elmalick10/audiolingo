import subprocess

def run(cmd):
    print("▶️", cmd)
    result = subprocess.run(cmd, shell=True)
    if result.returncode != 0:
        print("❌ ERREUR - arrêt du pipeline")
        exit()

# 1. Image → vidéo
run('ffmpeg -y -loop 1 -i C:\\audiolingo\\input\\image.jpg -vf "scale=trunc(iw/2)*2:trunc(ih/2)*2" -c:v libx264 -t 10 -pix_fmt yuv420p C:\\audiolingo\\output\\face.mp4')

# 2. Wav2Lip
run('python C:\\audiolingo\\ai\\Wav2Lip\\inference.py --checkpoint_path C:\\audiolingo\\ai\\Wav2Lip\\wav2lip.pth --face C:\\audiolingo\\output\\face.mp4 --audio C:\\audiolingo\\output\\voice.wav --outfile C:\\audiolingo\\output\\result.mp4')