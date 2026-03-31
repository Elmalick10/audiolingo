use crate::audio::rnnoise::denoise;
use crate::audio::demucs::separate_voice;
use crate::stt::whisper::speech_to_text;
use crate::translate::translator::translate;
use crate::voice::tts::speak;

pub fn realtime_translation(audio: Vec<f32>, target_lang: &str) -> Vec<f32> {

    let clean = denoise(audio);

    let voice = separate_voice(clean);

    let text = speech_to_text(voice);

    let translated = translate(text, target_lang);

    let audio_out = speak(translated);

    audio_out
}