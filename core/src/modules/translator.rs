use crate::types::Language;
use crate::error::Result;

pub struct Translator;

impl Translator {
    pub fn new() -> Result<Self> {
        Ok(Self)
    }

    pub fn translate(&self, text: &str, to: Language) -> Result<String> {
        let simulated_translation = format!("[{} translation] {}", to.code(), text);
        Ok(simulated_translation)
    }
}