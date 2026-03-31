use cpal::traits::{DeviceTrait, HostTrait, StreamTrait};
use crate::audio::buffer::AudioBuffer;

pub struct AudioIO {
    pub buffer: AudioBuffer,
}

impl AudioIO {
    pub fn new(_frames: usize) -> Self {
        Self { buffer: AudioBuffer::new() }
    }

    pub fn start(&self) -> Result<(), Box<dyn std::error::Error>> {
        let host = cpal::default_host();
        let device = host.default_input_device().ok_or("Pas de micro")?;
        let config = device.default_input_config()?;

        let buffer_clone = self.buffer.clone();
        let stream = device.build_input_stream(
            &config.into(),
            move |data: &[f32], _: &cpal::InputCallbackInfo| {
                buffer_clone.push(data);
            },
            move |err| eprintln!("Erreur audio: {:?}", err),
        )?;

        stream.play()?;
        Ok(())
    }
}