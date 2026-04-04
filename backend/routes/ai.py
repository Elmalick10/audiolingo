# routes/ai.py

from fastapi import APIRouter, UploadFile, File
from services.ai_pipeline import process_audio_pipeline
import shutil

from services.celery_worker import process_audio_task

@router.post("/ai/process")
async def process_audio(file: UploadFile = File(...)):
    file_path = f"storage/{file.filename}"

    with open(file_path, "wb") as buffer:
        shutil.copyfileobj(file.file, buffer)

    task = process_audio_task.delay(file_path)

    return {
        "task_id": task.id,
        "status": "processing"
    }

router = APIRouter()

@router.post("/ai/process")
async def process_audio(file: UploadFile = File(...)):
    file_path = f"storage/{file.filename}"

    with open(file_path, "wb") as buffer:
        shutil.copyfileobj(file.file, buffer)

    result = process_audio_pipeline(file_path)

    return result