import os

def run_wav2lip(video, audio, output):

    cmd = f"""
    python inference.py \
    --checkpoint_path wav2lip.pth \
    --face {video} \
    --audio {audio} \
    --outfile {output}
    """

    os.system(cmd)

    return output