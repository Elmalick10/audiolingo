pub const BUFFER_SIZE: usize = 1024;

pub struct AudioBuffer {
    pub data: Vec<f32>,
}

impl AudioBuffer {
    pub fn new() -> Self {
        Self {
            data: vec![0.0; BUFFER_SIZE],
        }
    }
}