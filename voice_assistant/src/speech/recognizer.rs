use whisper_rs::{FullParams, WhisperContext};
use crate::audio::buffer::AudioBuffer;

pub struct SpeechRecognizer {
    ctx: WhisperContext,
    buffer: AudioBuffer,
    sample_rate: f32,
}

impl SpeechRecognizer {
    pub fn new(buffer: AudioBuffer, model_path: &str, sample_rate: f32) -> Self {
        let ctx = WhisperContext::new(model_path).unwrap();
        Self { ctx, buffer, sample_rate }
    }

    pub fn poll(&mut self) -> Option<String> {
        let audio = self.buffer.get();
        if audio.is_empty() { return None; }

        let mut params = FullParams::new(whisper_rs::FullParamsFlags::DEFAULT);
        self.ctx.full(params, &audio, self.sample_rate as usize).ok()?;
        let text = self.ctx.get_text().unwrap_or_default();
        Some(text)
    }
}