use crate::lang::Language;

pub fn detect_language(text: &str) -> Language {
    if text.contains("bonjour") {
        Language::FR
    } else if text.contains("hola") {
        Language::ES
    } else {
        Language::EN
    }
}