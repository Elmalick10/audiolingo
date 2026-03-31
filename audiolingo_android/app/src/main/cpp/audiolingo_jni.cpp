#include <jni.h>
#include <string>

extern "C"
JNIEXPORT jstring JNICALL
Java_com_example_audiolingo_NativeBridge_processAudio(
        JNIEnv *env,
        jobject /* this */,
        jbyteArray audioData) {

    // TODO: connecter ton vrai moteur AudioLingo ici
    std::string result = "Texte simulé depuis STT offline";

    return env->NewStringUTF(result.c_str());
}