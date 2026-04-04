# services/ai_pipeline.py

from ai.whisper_onnx import transcribe_audio
from ai.tts_coqui import generate_tts
from ai.wav2lip_engine import generate_lipsync

def process_audio_pipeline(audio_path, target_lang="en", with_video=False):
    # 1. Speech-to-Text
    text = transcribe_audio(audio_path)

    # 2. Traduction (simple pour l'instant)
    translated_text = f"[{target_lang}] {text}"

    # 3. Text-to-Speech
    audio_output = generate_tts(translated_text)

    # 4. Vidéo (optionnel)
    video_output = None
    if with_video:
        video_output = generate_lipsync(audio_output)

    return {
        "text": text,
        "translated": translated_text,
        "audio": audio_output,
        "video": video_output
    }