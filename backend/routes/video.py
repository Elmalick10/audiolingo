from fastapi import APIRouter, UploadFile
from ai.wav2lip_engine import Wav2LipEngine
from core.queue import process_video

@router.post("/generate_async")
def generate_async():

    process_video.delay("data")

    return {
        "status": "processing"
    }

router = APIRouter(prefix="/video", tags=["Video"])
engine = Wav2LipEngine()

@router.post("/lipsync")
async def lipsync(face: UploadFile, audio: UploadFile):

    face_path = f"temp/{face.filename}"
    audio_path = f"temp/{audio.filename}"

    with open(face_path, "wb") as f:
        f.write(await face.read())

    with open(audio_path, "wb") as f:
        f.write(await audio.read())

    result = engine.generate(face_path, audio_path)

    return {
        "video_url": f"https://audiolingo.onrender.com/{result}"
    }