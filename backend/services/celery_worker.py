from celery import Celery
from services.celery_worker import app
from services.email_service import send_email
from services.retry_service import retry_payment

@app.task
def retry_payment_task(user_id):
    retry_payment(user_id)
@app.task
def send_email_task(to, subject, msg):
    send_email(to, subject, msg)
app = Celery(
    "audiolingo",
    broker="redis://localhost:6379/0",
    backend="redis://localhost:6379/0"
)