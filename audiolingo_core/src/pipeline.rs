use crate::modules::whisper::whisper_stream;
use crate::modules::detect_lang::detect_language;
use crate::modules::translate::translate;
use crate::modules::tts::synthesize;

pub fn process_audio(audio: &[f32]) {

    let text = whisper_stream(audio);

    let lang = detect_language(&text);

    let translated = translate(&text, "fr");

    let _voice = synthesize(&translated);

    println!("Detected: {}", lang);
    println!("Translated: {}", translated);

}