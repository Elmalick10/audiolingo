mod audio;
mod pipeline;
mod modules;
mod types;
mod error;
mod audio_processor;

use audio::io::start_microphone;
use pipeline::Pipeline;

#[tokio::main]
async fn main() {
    let pipeline = Pipeline::new().unwrap();

    start_microphone(move |data| {
        let input = data.to_vec();
        let pipeline = &pipeline;

        tokio::spawn(async move {
            let _ = pipeline.run(&input).await;
        });
    });
}