import os

def create_video():

    os.system("""
    ffmpeg -i input.mp4 -i voice.wav \
    -vf "subtitles=subs.srt:force_style='Fontsize=24'" \
    -c:v libx264 -c:a aac output.mp4
    """)

    return "output.mp4"

def upload_file(file):

    # upload vers storage cloud
    return "https://cdn.audiolingo.com/video.mp4"