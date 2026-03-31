#include "net.h"

ncnn::Net net;

extern "C"
JNIEXPORT void JNICALL
Java_com_example_audiolingo_ai_NCNNBridge_loadModel(JNIEnv *env, jobject thiz) {
    net.load_param("model.param");
    net.load_model("model.bin");
}