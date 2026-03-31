pub fn translate(text: String, lang: &str) -> String {

    if lang == "fr" {
        return format!("Traduction: {}", text);
    }

    text
}
pub fn translate(text: String, target_lang: &str) -> String {

    println!("Translating text to {}", target_lang);

    let translated = format!("translated({})", text);

    translated
}