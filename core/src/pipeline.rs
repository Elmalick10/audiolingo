use crate::modules::stt::SpeechToText;
use crate::modules::translator::Translator;
use crate::modules::tts;
use crate::services::microphone::Microphone;
use crate::error::Result;
use crate::types::Language;

pub async fn run_pipeline() -> Result<()> {
    let mic = Microphone::new()?;
    mic.start()?;

    let stt = SpeechToText::new()?;
    let translator = Translator::new()?;

    for _ in 0..5 {
        let audio_data = vec![0.0; 16000];

        let text = stt.transcribe(&audio_data).await?;
        println!("Transcription: {}", text);

        let translated = translator.translate(&text, Language::French)?;
        println!("Traduction: {}", translated);

        tts::speak(&translated)?;
    }

    mic.stop()?;
    Ok(())
}