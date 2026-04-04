import whisper
import torch

device = "cuda" if torch.cuda.is_available() else "cpu"

model = whisper.load_model("base", device=device)

def transcribe(audio_path):
    result = model.transcribe(audio_path)
    return result["text"]
model.to("cuda")