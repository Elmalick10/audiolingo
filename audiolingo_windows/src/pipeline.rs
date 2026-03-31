use crate::modules::{SpeechToText, Translator, TextToSpeech};
use anyhow::Result;

pub struct AudioLingoPipeline {
    stt: SpeechToText,
    translator: Translator,
    tts: TextToSpeech,
}

impl AudioLingoPipeline {
    pub fn new() -> Result<Self> {
        Ok(Self {
            stt: SpeechToText::new(),
            translator: Translator::new(),
            tts: TextToSpeech::new()?,
        })
    }

    pub async fn process_audio(&self, _audio: &[f32]) -> Result<()> {
        // 1. Transcrire
        let text = self.stt.transcribe(_audio).await?;
        println!("STT → {}", text);

        // 2. Traduire
        let translated = self.translator.translate(&text, "fr", "en").await?;
        println!("Traduction → {}", translated);

        // 3. TTS
        self.tts.speak(&translated)?;
        Ok(())
    }
}