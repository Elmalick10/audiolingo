use thiserror::Error;

#[derive(Error, Debug)]
pub enum Error {
    #[error("Audio error: {0}")]
    Audio(String),

    #[error("STT error: {0}")]
    Stt(String),
}

pub type Result<T> = std::result::Result<T, Error>;