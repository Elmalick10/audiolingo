use std::io::{self, Write};

pub fn listen() -> String {
    print!("🎤 Vous: ");
    io::stdout().flush().unwrap();
pub trait SpeechToTextEngine {
    fn transcribe(&self, audio: &[f32]) -> String;
pub struct VoskSTT;

impl VoskSTT {
pub fn new() -> Self {
        Self
    }

pub fn transcribe(&self, _audio: &[f32]) -> String {
        "Bonjour le monde".to_string()
    }
}
}
    let mut input = String::new();
    io::stdin().read_line(&mut input).unwrap();

    input.trim().to_string()
}