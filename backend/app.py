from fastapi import FastAPI
from routes.ai import router as ai_router
from routes.webhook import router as webhook_router

app = FastAPI()

app.include_router(ai_router)
app.include_router(webhook_router)

@app.get("/")
def home():
    return {"status": "AudioLingo API running 🚀"}

@app.get("/")
def home():
    return {"message": "AudioLingo API OK 🚀"}