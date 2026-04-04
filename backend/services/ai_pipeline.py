from services.stt import speech_to_text
from services.tts import text_to_speech

async def process_pipeline(text: str):

    # 🧠 Simulation (remplace par vraie IA plus tard)
    processed_text = text.upper()

    # 🔊 Génération audio
    audio_path = text_to_speech(processed_text)

    return {
        "input": text,
        "output": processed_text,
        "audio": audio_path
    }