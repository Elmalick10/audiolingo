from celery import Celery
from services.ai_pipeline import process_audio_pipeline

celery = Celery(
    "audiolingo",
    broker="redis://localhost:6379/0",
    backend="redis://localhost:6379/0"
)

@celery.task
def process_audio_task(audio_path):
    return process_audio_pipeline(audio_path)