pub fn detect_voice_type(audio: &Vec<f32>) -> String {

    if audio.len() > 10000 {
        "male".to_string()
    } else {
        "female".to_string()
    }

}