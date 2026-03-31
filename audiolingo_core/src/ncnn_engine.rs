pub fn run_inference(audio: Vec<f32>) -> String {

    // simulation inference
    if audio.len() > 0 {
        return "Speech detected".to_string();
    }

    "No speech".to_string()

}