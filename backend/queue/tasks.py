from ai.whisper_engine import transcribe
from rq import Queue
import redis
from queue.tasks import process_audio_task

redis_conn = redis.Redis()
q = Queue(connection=redis_conn)

job = q.enqueue(process_audio_task, path)

def process_audio_task(path):
    return transcribe(path)