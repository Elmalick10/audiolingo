pub mod pipeline;
pub mod modules;

use pipeline::process_audio;

// Fonction exposée à Kotlin via JNI
#[no_mangle]
pub extern "C" fn process_audio_jni(ptr: *const f32, len: usize) {
    let slice = unsafe { std::slice::from_raw_parts(ptr, len) };
    process_audio(slice);
}