pub fn separate_voice(input: Vec<f32>) -> Vec<f32> {

    input.into_iter().filter(|s| s.abs() > 0.01).collect()

}