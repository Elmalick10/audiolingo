use vosk::{Model, Recognizer};
use crate::audio::buffer::AudioBuffer;

pub struct SpeechRecognizer {
    recognizer: Recognizer,
    buffer: AudioBuffer,
}

impl SpeechRecognizer {
    pub fn new(buffer: AudioBuffer, model_path: &str, sample_rate: f32) -> Self {
        let model = Model::new(model_path).expect("Impossible de charger le modèle Vosk");
        let recognizer = Recognizer::new(&model, sample_rate);
        Self { recognizer, buffer }
    }

    pub fn poll(&mut self) -> Option<String> {
        let mut audio_chunk = vec![0.0; 1024];
        let n = self.buffer.pop(&mut audio_chunk);
        if n == 0 { return None; }

        if self.recognizer.accept_waveform(&audio_chunk[..n]) {
            let result = self.recognizer.result();
            Some(result.text)
        } else {
            None
        }
    }
}