use crate::error::Result;

pub struct SpeechToText;

impl SpeechToText {
    pub fn new() -> Result<Self> {
        Ok(Self)
    }

    pub async fn transcribe(&self, _samples: &[f32]) -> Result<String> {
        Ok("Sample transcription".to_string())
    }
}