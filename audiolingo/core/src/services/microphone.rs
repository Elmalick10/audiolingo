use crate::error::{Result};
use std::sync::{Arc, Mutex};

pub struct Microphone {
    buffer: Arc<Mutex<Vec<f32>>>,
    is_running: Arc<Mutex<bool>>,
}

impl Microphone {
    pub fn new() -> Result<Self> {
        Ok(Self {
            buffer: Arc::new(Mutex::new(Vec::new())),
            is_running: Arc::new(Mutex::new(false)),
        })
    }

    pub fn start(&self) -> Result<()> {
        *self.is_running.lock().unwrap() = true;
        println!("Microphone started (simulé)");
        Ok(())
    }

    pub fn capture(&self) -> Result<Vec<f32>> {
        Ok(vec![0.0; 160]) // Placeholder
    }

    pub fn stop(&self) -> Result<()> {
        *self.is_running.lock().unwrap() = false;
        println!("Microphone stopped");
        Ok(())
    }
}