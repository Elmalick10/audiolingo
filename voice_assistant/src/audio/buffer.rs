use std::sync::{Arc, Mutex};

#[derive(Clone)]
pub struct AudioBuffer {
    pub data: Arc<Mutex<Vec<f32>>>,
}

impl AudioBuffer {
    pub fn new() -> Self {
        Self { data: Arc::new(Mutex::new(Vec::new())) }
    }

    pub fn push(&self, chunk: &[f32]) {
        let mut data = self.data.lock().unwrap();
        data.extend_from_slice(chunk);
    }

    pub fn clear(&self) {
        let mut data = self.data.lock().unwrap();
        data.clear();
    }

    pub fn get(&self) -> Vec<f32> {
        self.data.lock().unwrap().clone()
    }
}