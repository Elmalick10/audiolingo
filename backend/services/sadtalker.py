import os

def run_sadtalker(image, audio):

    output = image.replace(".jpg", "_animated.mp4")

    cmd = f"""
    python inference.py \
    --source_image {image} \
    --driven_audio {audio} \
    --result_dir temp/
    """

    os.system(cmd)

    return output