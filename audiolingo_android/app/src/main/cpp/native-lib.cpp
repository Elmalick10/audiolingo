#include <jni.h>
#include <string>

extern "C"
JNIEXPORT jstring JNICALL
Java_com_example_audiolingo_MainActivity_stringFromJNI(JNIEnv* env, jobject thiz) {
    std::string hello = "AudioLingo Core OK 🚀";
    return env->NewStringUTF(hello.c_str());
}