import os
import requests
import tqdm
from model_loader import ensure_models

ensure_models()

MODELS = {
    "demucs": "https://example.com/demucs.onnx",
    "whisper": "https://example.com/ggml-base.bin"
}

def download_file(url, path):
    r = requests.get(url, stream=True)
    with open(path, "wb") as f:
        for chunk in r.iter_content(chunk_size=8192):
            if chunk:
                f.write(chunk)

def ensure_models():
    os.makedirs("models", exist_ok=True)

    for name, url in MODELS.items():
        path = f"models/{name}"

        if not os.path.exists(path):
            print(f"Téléchargement {name}...")
            download_file(url, path)

    print("Tous les modèles sont prêts")