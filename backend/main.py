from fastapi import FastAPI, UploadFile, File
import shutil
import uuid
from services.video_pipeline import generate_video
from fastapi import FastAPI
from routes import auth, admin, analytics

app = FastAPI()

app.include_router(auth.router)
app.include_router(admin.router)
app.include_router(analytics.router)

app = FastAPI()

@app.post("/avatar")
async def create_avatar(image: UploadFile = File(...), audio: UploadFile = File(...)):

    task_id = str(uuid.uuid4())

    image_path = f"temp/{task_id}_img.jpg"
    audio_path = f"temp/{task_id}_audio.wav"
    output_path = f"outputs/{task_id}.mp4"

    # Save files
    with open(image_path, "wb") as buffer:
        shutil.copyfileobj(image.file, buffer)

    with open(audio_path, "wb") as buffer:
        shutil.copyfileobj(audio.file, buffer)

    # Generate video
    generate_video(image_path, audio_path, output_path)

    return {"video_url": f"/video/{task_id}.mp4"}

@app.get("/")
def home():
    return {"message": "AudioLingo API OK 🚀"}