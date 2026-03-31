use std::sync::atomic::{AtomicUsize, Ordering};

pub struct RingBuffer {
    buffer: Vec<f32>,
    size: usize,
    write: AtomicUsize,
    read: AtomicUsize,
}

impl RingBuffer {

    pub fn new(size: usize) -> Self {
        Self {
            buffer: vec![0.0; size],
            size,
            write: AtomicUsize::new(0),
            read: AtomicUsize::new(0),
        }
    }

    pub fn push(&mut self, input: &[f32]) {
        let w = self.write.load(Ordering::Relaxed);

        for (i, sample) in input.iter().enumerate() {
            self.buffer[(w + i) % self.size] = *sample;
        }

        self.write.store(w + input.len(), Ordering::Relaxed);
    }

    pub fn pop(&mut self, output: &mut [f32]) -> usize {

        let r = self.read.load(Ordering::Relaxed);
        let w = self.write.load(Ordering::Relaxed);

        let available = w - r;
        let n = available.min(output.len());

        for i in 0..n {
            output[i] = self.buffer[(r + i) % self.size];
        }

        self.read.store(r + n, Ordering::Relaxed);

        n
    }
}