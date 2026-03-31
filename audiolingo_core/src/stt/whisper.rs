pub fn speech_to_text(audio: Vec<f32>) -> String {

    let model_path = "C:/audiolingo/models/whisper/ggml-tiny.bin";

    println!("Using Whisper model: {}", model_path);

    "hello world".to_string()
}
pub fn transcribe(audio: Vec<f32>) -> String {

    println!("Running Whisper STT...");

    let text = String::from("hello world");

    text
}