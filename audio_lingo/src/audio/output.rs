use rodio::{OutputStream, Sink, buffer::SamplesBuffer};

pub fn play_audio(samples: Vec<f32>) {
    let (_stream, handle) = OutputStream::try_default().unwrap();
    let sink = Sink::try_new(&handle).unwrap();

    let source = SamplesBuffer::new(1, 44100, samples);
    sink.append(source);
    sink.sleep_until_end();
}