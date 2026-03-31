from flask import request, jsonify
from services.ai_engine import generate_user_content

def create_video():

    data = request.json
    user_id = data["user_id"]
    prompt = data["prompt"]

    content = generate_user_content(user_id, prompt)

    # génération audio + vidéo
    video_path = generate_avatar(user_id)

    return jsonify({
        "video": video_path,
        "content": content
    })