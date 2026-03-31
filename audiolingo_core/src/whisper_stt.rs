use whisper_rs::{FullParams, SamplingStrategy, WhisperContext};

pub fn transcribe(audio: Vec<f32>) -> String {

    let ctx = WhisperContext::new("models/ggml-base.bin")
        .expect("model load failed");

    let mut state = ctx.create_state().unwrap();

    let mut params = FullParams::new(SamplingStrategy::Greedy { best_of: 1 });

    params.set_language(Some("auto"));

    state.full(params, &audio[..]).unwrap();

    let mut result = String::new();

    let num_segments = state.full_n_segments();

    for i in 0..num_segments {
        let segment = state.full_get_segment_text(i).unwrap();
        result.push_str(segment);
    }

    result
}