import subprocess

def sync_video(video, audio):

    output = "synced.mp4"

    cmd = [
        "ffmpeg",
        "-i", video,
        "-i", audio,
        "-c:v", "copy",
        "-c:a", "aac",
        output
    ]

    subprocess.run(cmd)

    return output