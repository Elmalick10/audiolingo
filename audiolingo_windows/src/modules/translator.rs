use anyhow::Result;

pub struct Translator;

impl Translator {
    pub fn new() -> Self {
        Self
    }

    pub async fn translate(&self, text: &str, _source: &str, _target: &str) -> Result<String> {
        // Placeholder : ici on ajoute simplement le préfixe de la langue
        Ok(format!("[FR→EN] {}", text))
    }
}