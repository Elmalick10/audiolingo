use crate::audio::queue::AudioQueue;
use tts::Tts;
use whatlang::Lang;

pub struct SpeechSynthesizer {
    tts: Tts,
    queue: AudioQueue,
}

impl SpeechSynthesizer {
    pub fn new(queue: AudioQueue) -> Self {
        let tts = Tts::default().expect("Impossible d'initialiser TTS");
        Self { tts, queue }
    }

    pub fn speak(&mut self, text: &str, lang: Lang) {
        let voice = match lang {
            Lang::Fra => "fr-FR",
            Lang::Eng => "en-US",
            Lang::Spa => "es-ES",
            _ => "en-US",
        };
        self.tts.set_voice(voice).unwrap_or(());

        if let Ok(audio_data) = self.tts.speak_to_buffer(text) {
            self.queue.push(audio_data);
        }
    }
}