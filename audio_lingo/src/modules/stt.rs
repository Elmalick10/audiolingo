use vosk::{Model, Recognizer};
use crate::error::Result;

pub struct SpeechToText {
    recognizer: Recognizer,
}

impl SpeechToText {
    pub fn new() -> Result<Self> {
        let model = Model::new("models/vosk-model-small-en-us-0.15")?;
        let recognizer = Recognizer::new(&model, 16000.0)?;
        Ok(Self { recognizer })
    }

    pub async fn transcribe(&self, audio: &[f32]) -> Result<String> {
        self.recognizer.accept_waveform(audio);
        let result = self.recognizer.final_result();
        Ok(result.text)
    }
}