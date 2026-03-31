use tts::Tts;
use crate::audio::buffer::AudioBuffer;
use whatlang::Lang;

pub struct SpeechSynthesizer {
    tts: Tts,
    buffer: AudioBuffer,
}

impl SpeechSynthesizer {
    pub fn new(buffer: AudioBuffer) -> Self {
        let tts = Tts::default().expect("Impossible d'initialiser TTS");
        Self { tts, buffer }
    }

    pub fn speak(&mut self, text: &str, lang: Lang) {
        // définir la voix en fonction de la langue
        let voice = match lang {
            Lang::Fra => "fr-FR", // français
            Lang::Eng => "en-US", // anglais
            Lang::Spa => "es-ES", // espagnol
            _ => "en-US",
        };
        self.tts.set_voice(voice).unwrap_or(());

        let audio_data: Vec<f32> = self.tts.speak_to_buffer(text).unwrap();
        self.buffer.push(&audio_data);
    }
}