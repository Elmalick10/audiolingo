use cpal::traits::{DeviceTrait, HostTrait, StreamTrait};

pub fn capture_system_audio() {
    let host = cpal::default_host();
    let device = host.default_output_device().expect("No output device");

    println!("Capture audio système depuis : {}", device.name().unwrap());
}