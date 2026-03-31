use cpal::traits::{DeviceTrait, HostTrait, StreamTrait};
use std::sync::{Arc, Mutex};

fn main() -> Result<(), Box<dyn std::error::Error>> {
    // 1. Choisir le host audio par défaut
    let host = cpal::default_host();

    // 2. Microphone et haut-parleur par défaut
    let input_device = host
        .default_input_device()
        .expect("Impossible de trouver un micro");
    let output_device = host
        .default_output_device()
        .expect("Impossible de trouver un haut-parleur");

    println!("Micro: {}", input_device.name()?);
    println!("Speaker: {}", output_device.name()?);

    // 3. Config micro
    let input_config = input_device.default_input_config()?;
    let sample_rate = input_config.sample_rate().0 as usize;
    let channels = input_config.channels() as usize;

    println!(
        "Config micro: {} Hz, {} canaux, format {:?}",
        sample_rate, channels, input_config.sample_format()
    );

    // Ring buffer simple
    let buffer = Arc::new(Mutex::new(Vec::<f32>::with_capacity(sample_rate * channels)));

    // 4. Stream micro
    let buffer_in = buffer.clone();
    let input_stream = input_device.build_input_stream(
        &input_config.into(),
        move |data: &[f32], _: &cpal::InputCallbackInfo| {
            let mut buf = buffer_in.lock().unwrap();
            buf.extend_from_slice(data);
            if buf.len() > sample_rate * 2 { // limiter à 2s de buffer
                buf.drain(0..buf.len() - sample_rate * 2);
            }
        },
        move |err| eprintln!("Erreur micro: {:?}", err),
    )?;

    // 5. Stream haut-parleur
    let buffer_out = buffer.clone();
    let output_config = output_device.default_output_config()?;
    let output_stream = output_device.build_output_stream(
        &output_config.into(),
        move |output: &mut [f32], _: &cpal::OutputCallbackInfo| {
            let mut buf = buffer_out.lock().unwrap();
            for sample in output.iter_mut() {
                if let Some(s) = buf.first() {
                    *sample = *s;
                    buf.remove(0);
                } else {
                    *sample = 0.0; // silence si buffer vide
                }
            }
        },
        move |err| eprintln!("Erreur speaker: {:?}", err),
    )?;

    println!("Démarrage micro ↔ haut-parleur (Ctrl+C pour quitter)...");
    input_stream.play()?;
    output_stream.play()?;

    // Boucle infinie
    loop {
        std::thread::sleep(std::time::Duration::from_secs(1));
    }
}