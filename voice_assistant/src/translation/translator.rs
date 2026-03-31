use crate::lang::Language;

pub struct Translator;

impl Translator {
    pub fn new() -> Self {
        Self
    }

    pub fn translate(&self, text: &str, from: Language, to: Language) -> String {
        if from.code() == to.code() {
            return text.to_string();
        }

        format!("[{} → {}] {}", from.code(), to.code(), text)
    }
}