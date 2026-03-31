#include "net.h"

ncnn::Net net;

extern "C"
JNIEXPORT void JNICALL
Java_com_example_audiolingo_ai_voice_XTTSBridge_load(JNIEnv *env, jobject thiz) {
    net.load_param("xtts.param");
    net.load_model("xtts.bin");
}