use audiolingo_core::pipeline::process_audio;

fn main() {

    println!("AudioLingo Windows démarré");

    let fake_audio: Vec<f32> = vec![0.0;16000];

    process_audio(&fake_audio);

    println!("Audio traité !");
}