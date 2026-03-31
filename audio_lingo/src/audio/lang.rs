use whatlang::{detect, Lang};

pub fn detect_language(text: &str) -> Lang {
    if let Some(info) = detect(text) {
        info.lang()
    } else {
        Lang::Eng // défaut
    }
}