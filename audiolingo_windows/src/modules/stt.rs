use anyhow::Result;

pub struct SpeechToText;

impl SpeechToText {
    pub fn new() -> Self {
        Self
    }

    pub async fn transcribe(&self, _audio: &[f32]) -> Result<String> {
        // Placeholder : à remplacer par Whisper ou autre
        Ok("Ceci est un texte simulé".to_string())
    }
}