use crate::audio::buffer::{AudioBuffer, BUFFER_SIZE};

pub fn process_audio() {
    let mut buffer = AudioBuffer::new();

    loop {
        // simulation capture audio
        for sample in &mut buffer.data {
            *sample = 0.5;
        }

        println!("Traitement {} samples", BUFFER_SIZE);
    }
}

use std::thread;

pub fn start_audio_threads() {
    // 🎙 Capture
    thread::spawn(|| {
        println!("Thread capture audio démarré");
    });

    // 🧠 Traitement
    thread::spawn(|| {
        println!("Thread traitement audio démarré");
    });

    // 🔊 Sortie
    thread::spawn(|| {
        println!("Thread sortie audio démarré");
    });
}