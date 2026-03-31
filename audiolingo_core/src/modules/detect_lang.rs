pub fn detect_language(text: &str) -> String {

    if text.contains("the") {
        return "en".to_string();
    }

    if text.contains("le") {
        return "fr".to_string();
    }

    "unknown".to_string()
}