use crate::error::Result;

pub fn speak(text: &str) -> Result<()> {
    println!("TTS: {}", text);
    Ok(())
}