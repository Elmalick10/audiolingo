mod ui;
mod pipeline;
mod lang;

use ui::app::AudioLingoApp;

fn main() -> eframe::Result<()> {
    let options = eframe::NativeOptions::default();

fn main() {
    println!("AudioLingo Pipeline démarré");
    pipeline::Pipeline::run();

    eframe::run_native(
        "AudioLingo",
        options,
        Box::new(|_| Box::new(AudioLingoApp::default())),
    )
}