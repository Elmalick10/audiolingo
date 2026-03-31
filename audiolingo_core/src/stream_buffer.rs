pub struct StreamBuffer {

    pub buffer: Vec<f32>,

}

impl StreamBuffer {

    pub fn new() -> Self {

        Self {
            buffer: Vec::new()
        }

    }

    pub fn push(&mut self, audio: Vec<f32>) {

        self.buffer.extend(audio);

    }

    pub fn pop_chunk(&mut self, size: usize) -> Option<Vec<f32>> {

        if self.buffer.len() >= size {

            let chunk: Vec<f32> = self.buffer.drain(0..size).collect();

            Some(chunk)

        } else {

            None

        }

    }

}