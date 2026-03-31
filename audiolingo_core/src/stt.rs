use whisper_rs::{WhisperContext, FullParams, SamplingStrategy};

pub fn transcribe(audio: Vec<f32>) {

    // Charger le modèle Whisper
    let ctx = WhisperContext::new_with_params("model.bin", Default::default())
        .expect("Failed to load model");

    let mut state = ctx.create_state().unwrap();

    // paramètres d'inférence
    let mut params = FullParams::new(SamplingStrategy::Greedy { best_of: 1 });

    params.set_n_threads(2);

    // lancer la transcription
    state.full(params, &audio).unwrap();

    let num_segments = state.full_n_segments().unwrap();

    for i in 0..num_segments {
        let text = state.full_get_segment_text(i).unwrap();
        println!("{}", text);
    }
}