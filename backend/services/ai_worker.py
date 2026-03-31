from celery_worker import app

@app.task
def generate_ai_video(prompt):

    print("🎬 génération GPU")

    return "video.mp4"