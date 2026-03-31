use crate::services::microphone::Microphone;
use crate::modules::stt::SpeechToText;
use crate::audio_processor::AudioProcessor;
use crate::error::Result;
use tokio::time::{sleep, Duration};

pub struct Pipeline {
    mic: Microphone,
    stt: SpeechToText,
    processor: AudioProcessor,
}

impl Pipeline {
    pub async fn new() -> Result<Self> {
        Ok(Self {
            mic: Microphone::new()?,
            stt: SpeechToText::new()?,
            processor: AudioProcessor::new(),
        })
    }

    pub async fn run(&self) -> Result<()> {
        self.mic.start()?;
        for _ in 0..5 {
            let mut audio = self.mic.capture()?;
            self.processor.process(&mut audio);
            let transcript = self.stt.transcribe(&audio).await?;
            println!("Transcription: {}", transcript);
            sleep(Duration::from_millis(500)).await;
        }
        self.mic.stop()?;
        Ok(())
    }
}