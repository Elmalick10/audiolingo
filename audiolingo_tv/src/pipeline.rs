use crate::modules::rnnoise::rnnoise_filter;
use crate::modules::demucs::separate;
use crate::modules::whisper::whisper_stream;
use crate::modules::translate::translate;
use crate::modules::tts::synthesize;
use crate::modules::lipsync::lipsync;

pub fn process_audio(input: &[f32]) {
    // 1. Suppression bruit
    let clean = rnnoise_filter(input);

    // 2. Séparation voix
    let voice = separate(clean);

    // 3. Transcription en streaming
    let text = whisper_stream(&voice);

    // 4. Détection et traduction
    let translated = translate(&text, "fr");

    // 5. Synthèse vocale
    let tts_audio = synthesize(&translated);

    // 6. Lip-sync si nécessaire
    lipsync(&tts_audio);

    // Output vers TV / haut-parleur
    println!("Audio traité prêt !");
}