use jni::JNIEnv;
use jni::objects::{JClass, JShortArray};
use jni::sys::{jint, jshortArray};

mod modules;
mod pipeline;
mod ring_buffer;

pub mod modules;
pub mod pipeline;

#[no_mangle]
pub extern "system" fn Java_com_audiolingo_Native_processAudio(
    env: JNIEnv,
    _class: JClass,
    input_audio: JShortArray,
    _sample_rate: jint,
) -> jshortArray {

    let len = match input_audio.len(&env) {
        Ok(v) => v,
        Err(_) => return std::ptr::null_mut(),
    };

    let mut buffer = vec![0i16; len];

    if input_audio.get_region(&env, 0, &mut buffer).is_err() {
        return std::ptr::null_mut();
    }

    let output_audio = match pipeline::process_audio(buffer) {
        Ok(v) => v,
        Err(_) => return std::ptr::null_mut(),
    };

    let result_array = match env.new_short_array(output_audio.len()) {
        Ok(arr) => arr,
        Err(_) => return std::ptr::null_mut(),
    };

    if result_array.set_region(&env, 0, &output_audio).is_err() {
        return std::ptr::null_mut();
    }

    result_array.into_raw()
}
#[no_mangle]
pub extern "C" fn process_audio_frame(frame: *const i16, len: usize) {
    let slice = unsafe { std::slice::from_raw_parts(frame, len) };
    process_audio_frame(slice);
}