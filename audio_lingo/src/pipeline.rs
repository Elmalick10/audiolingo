use crate::modules::{stt::SpeechToText, translator::Translator, tts::TextToSpeech};
use crate::types::Language;
use crate::audio_processor::AudioProcessor;
use crate::error::Result;

pub struct Pipeline {
    audio: AudioProcessor,
    stt: SpeechToText,
    translator: Translator,
    tts: TextToSpeech,
}

impl Pipeline {
    pub fn new() -> Result<Self> {
        Ok(Self {
            audio: AudioProcessor::new(),
            stt: SpeechToText::new()?,
            translator: Translator::new()?,
            tts: TextToSpeech::new()?,
        })
    }

    pub async fn run(&self, input: &[f32]) -> Result<()> {
        println!("Pipeline démarré");

        let processed = self.audio.process(input);

        let text = self.stt.transcribe(&processed).await?;
        println!("STT → {}", text);

        let translated = self.translator.translate(&text, Language::French)?;
        println!("TRAD → {}", translated);

        self.tts.speak(&translated)?;
        Ok(())
    }
}