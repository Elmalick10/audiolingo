from celery import Celery

celery = Celery(
    "worker",
    broker="redis://localhost:6379/0"
)

@celery.task
def process_video(prompt):

    # ici ton IA
    print("Génération vidéo :", prompt)

    return "done"