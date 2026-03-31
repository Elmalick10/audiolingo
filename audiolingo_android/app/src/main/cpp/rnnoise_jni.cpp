#include <jni.h>

extern "C"
JNIEXPORT jfloatArray JNICALL
Java_com_example_audiolingo_audio_RNNoiseProcessor_processFrame(
        JNIEnv* env,
        jobject,
        jfloatArray input) {

    jsize len = env->GetArrayLength(input);
    jfloat* data = env->GetFloatArrayElements(input, 0);

    // 🔥 ici tu branches RNNoise réel

    jfloatArray output = env->NewFloatArray(len);
    env->SetFloatArrayRegion(output, 0, len, data);

    env->ReleaseFloatArrayElements(input, data, 0);

    return output;
}