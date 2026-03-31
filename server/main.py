from fastapi import FastAPI
import uvicorn

app = FastAPI()

@app.get("/")
def status():
    return {"server": "AudioLingo running"}

if __name__ == "__main__":
    uvicorn.run(app, host="0.0.0.0", port=8000)