#include <jni.h>
#include <oboe/Oboe.h>
#include <android/log.h>
#include <thread>

#include "audio_queue.h"

#define LOGI(...) __android_log_print(ANDROID_LOG_INFO,"AudioLingo",__VA_ARGS__)

static AudioQueue audioQueue;

extern "C" {

void audiolingo_process_audio(int16_t* data, int len);

}

#include "rnnoise.h"
#include "whisper.h"
#include "net.h"

void process_audio(float* audio) {

    // 1 suppression bruit
    float* clean = rnnoise_process(audio);

    // 2 séparation voix
    float* voice = demucs_process(clean);

    // 3 transcription
    const char* text = whisper_transcribe(voice);

}

void worker_thread() {

    while(true) {

        auto buffer = audioQueue.pop();

        audiolingo_process_audio(buffer.data(), buffer.size());

    }

}

class AudioCallback : public oboe::AudioStreamCallback {

public:

    oboe::DataCallbackResult
    onAudioReady(oboe::AudioStream* stream,
                 void* audioData,
                 int32_t numFrames) override {

        float* input = static_cast<float*>(audioData);

        std::vector<int16_t> pcm(numFrames);

        for(int i=0;i<numFrames;i++){

            float f = input[i];

            if(f>1) f=1;
            if(f<-1) f=-1;

            pcm[i] = (int16_t)(f*32767);

        }

        audioQueue.push(std::move(pcm));

        return oboe::DataCallbackResult::Continue;
    }

};

extern "C"
JNIEXPORT void JNICALL
Java_com_audiolingo_MainActivity_startOboe(
        JNIEnv *env,
        jobject thiz) {

    static bool started=false;

    if(!started){

        std::thread(worker_thread).detach();
        started=true;

    }

    oboe::AudioStreamBuilder builder;

    builder.setDirection(oboe::Direction::Input);
    builder.setPerformanceMode(oboe::PerformanceMode::LowLatency);
    builder.setSharingMode(oboe::SharingMode::Exclusive);
    builder.setFormat(oboe::AudioFormat::Float);
    builder.setChannelCount(oboe::ChannelCount::Mono);
    builder.setSampleRate(16000);
    builder.setCallback(new AudioCallback());

    oboe::AudioStream* stream=nullptr;

    if(builder.openStream(&stream)==oboe::Result::OK){

        stream->requestStart();
        LOGI("AudioLingo Oboe started");

    } else {

        LOGI("Failed start Oboe");

    }
}