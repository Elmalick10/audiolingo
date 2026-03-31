use std::sync::{Arc, Mutex, mpsc};
use rodio::{OutputStream, Sink, source::Source};
use std::thread;

pub struct AudioQueue {
    sender: mpsc::Sender<Vec<f32>>,
}

impl AudioQueue {
    pub fn new() -> Self {
        let (sender, receiver) = mpsc::channel::<Vec<f32>>();
        thread::spawn(move || {
            let (_stream, stream_handle) = OutputStream::try_default().unwrap();
            let sink = Sink::try_new(&stream_handle).unwrap();

            for audio_chunk in receiver {
                let source = rodio::buffer::SamplesBuffer::new(1, 48000, audio_chunk);
                sink.append(source);
            }
        });

        Self { sender }
    }

    pub fn push(&self, chunk: Vec<f32>) {
        let _ = self.sender.send(chunk);
    }
}