use crate::rnnoise::denoise;
use crate::ncnn_engine::run_inference;

pub fn process_audio(mut audio: Vec<f32>) -> String {

    denoise(&mut audio);

    let text = run_inference(audio);

    text

}
pub fn process_audio(samples: Vec<i16>) {

    // RNNoise
    let denoised = rnnoise_process(&samples);

    // Demucs
    let voice = demucs_process(&denoised);

    // Whisper
    let text = whisper_process(&voice);

    println!("Transcription: {}", text);

}