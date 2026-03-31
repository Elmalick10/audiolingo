pub fn translate(text: &str, lang: &str) -> String {
    format!("{} [traduit en {}]", text, lang)
}