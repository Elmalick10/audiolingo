mod audio_pipeline;
mod rnnoise;
mod ncnn_engine;
mod onnx_engine;

use jni::JNIEnv;
use jni::objects::JClass;
use jni::sys::jstring;

#[no_mangle]
pub extern "system" fn Java_com_audiolingo_MainActivity_processAudio(
    env: JNIEnv,
    _class: JClass,
) -> jstring {

    let text = "Listening...";

    env.new_string(text)
        .unwrap()
        .into_raw()

}