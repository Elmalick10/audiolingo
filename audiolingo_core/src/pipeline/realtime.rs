use crate::stt::whisper::speech_to_text;
use crate::translate::translator::translate;
use crate::tts::xtts::speak;
use crate::audio::capture;
use crate::audio::rnnoise;
use crate::stt::whisper;
use crate::translation::translator;
use crate::voice::tts;

pub fn start_pipeline() {

    println!("Starting realtime pipeline...");

    let audio = capture::capture_audio();

    let clean_audio = rnnoise::denoise(audio);

    let text = whisper::transcribe(clean_audio);

    let translated = translator::translate(text, "fr");

    let speech = tts::synthesize(translated);

    println!("Pipeline completed. Output size: {}", speech.len());

}

pub fn realtime(audio: Vec<f32>, lang: &str) -> Vec<f32> {

    let text = speech_to_text(audio);

    let translated = translate(text, lang);

    let voice = speak(translated);

    voice
}