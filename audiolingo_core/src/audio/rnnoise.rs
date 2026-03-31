pub fn denoise(input: Vec<f32>) -> Vec<f32> {

    let mut output = Vec::new();

    for sample in input {
        // simple filtre placeholder
        output.push(sample * 0.95);
    }

    output
}
pub fn denoise(input: Vec<f32>) -> Vec<f32> {

    input.into_iter().map(|x| x * 0.98).collect()

}
pub fn denoise(audio: Vec<f32>) -> Vec<f32> {

    println!("Running RNNoise filter...");

    audio
}