pub fn reduce_noise(samples: &mut [f32]) {
    let threshold = 0.02;

    for s in samples.iter_mut() {
        if s.abs() < threshold {
            *s = 0.0;
        }
    }
}