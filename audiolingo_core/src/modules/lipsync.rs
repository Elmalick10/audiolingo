// Convertit un texte en phonèmes (simplifié)
pub fn text_to_phonemes(text: &str) -> Vec<String> {

    text.split_whitespace()
        .map(|w| w.to_string())
        .collect()

}


// Convertit phonèmes → visèmes (formes de bouche)
pub fn phoneme_to_viseme(phonemes: Vec<String>) -> Vec<String> {

    phonemes
        .into_iter()
        .map(|p| {

            match p.as_str() {

                "a" => "viseme_A".to_string(),
                "o" => "viseme_O".to_string(),
                "m" => "viseme_M".to_string(),

                _ => "viseme_default".to_string()

            }

        })
        .collect()

}