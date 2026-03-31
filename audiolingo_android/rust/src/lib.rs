use jni::JNIEnv;
use jni::objects::JObject;

#[no_mangle]
pub extern "system" fn Java_com_audiolingo_MainActivity_startListening(
    _env: JNIEnv,
    _obj: JObject,
) {
    println!("AudioLingo Rust listening...");
}