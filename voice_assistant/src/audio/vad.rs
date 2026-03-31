pub fn is_voice(audio: &[f32]) -> bool {
    let energy: f32 = audio.iter().map(|x| x.abs()).sum::<f32>() / audio.len() as f32;
    energy > 0.01
}