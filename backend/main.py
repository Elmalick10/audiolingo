from fastapi import FastAPI, UploadFile, File
import shutil

app = FastAPI()

@app.post("/ai/process")
async def process_text(data: dict):
    text = data.get("text")
    return {
        "output": text.upper(),
        "status": "processed"
    }

@app.post("/ai/audio")
async def process_audio(file: UploadFile = File(...)):
    path = f"temp_{file.filename}"

    with open(path, "wb") as buffer:
        shutil.copyfileobj(file.file, buffer)

    # TODO: Whisper + TTS
    return {
        "output": "audio processed",
        "status": "ok"
    }