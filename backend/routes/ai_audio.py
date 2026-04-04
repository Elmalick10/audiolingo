from fastapi import APIRouter, UploadFile, File
import shutil
from ai.whisper_engine import transcribe

router = APIRouter()

@router.post("/ai/audio")
async def process_audio(file: UploadFile = File(...)):
    path = f"temp_{file.filename}"

    with open(path, "wb") as buffer:
        shutil.copyfileobj(file.file, buffer)

    text = transcribe(path)

    return {
        "output": text,
        "status": "ok"
    }