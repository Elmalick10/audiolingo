use whisper_rs::{WhisperContext, WhisperContextParameters};

pub fn init_whisper(model_path:&str)->WhisperContext{

    let params = WhisperContextParameters::default();

    WhisperContext::new_with_params(model_path, params)
        .expect("Whisper init failed")

}
static mut AUDIO_BUFFER: Vec<f32> = Vec::new();

pub fn push_audio(frame: &[f32]) {

    unsafe {

        AUDIO_BUFFER.extend_from_slice(frame);

        if AUDIO_BUFFER.len() > 16000 {

            transcribe();

            AUDIO_BUFFER.clear();

        }

    }

}

fn transcribe() {

    println!("speech detected");

}