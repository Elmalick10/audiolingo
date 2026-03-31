use std::thread;
use std::sync::mpsc;

pub fn start_pipeline() {

    let (tx_audio, rx_audio) = mpsc::channel();
    let (tx_text, rx_text) = mpsc::channel();

    // thread Whisper
    thread::spawn(move || {

        for audio in rx_audio {

            let text = crate::modules::whisper::whisper_stream(&audio);

            tx_text.send(text).unwrap();
        }

    });

    // thread TTS
    thread::spawn(move || {

        for text in rx_text {

            let _voice = crate::modules::tts::synthesize(&text);

        }

    });

}