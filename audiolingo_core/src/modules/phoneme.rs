pub fn text_to_phonemes(text: &str) -> Vec<String> {

    let mut phonemes = Vec::new();

    for c in text.chars() {

        match c {
            'a' => phonemes.push("AA".to_string()),
            'o' => phonemes.push("OO".to_string()),
            'm' => phonemes.push("MM".to_string()),
            _ => phonemes.push("REST".to_string())
        }

    }

    phonemes
}