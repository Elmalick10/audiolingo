from celery import Celery

celery = Celery(
    "audiolingo",
    broker="redis://localhost:6379/0"
)

@celery.task
def process_video(data):
    print("Processing video...")