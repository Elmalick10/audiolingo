#include "whisper.h"

static whisper_context *ctx = nullptr;

void init_whisper(const char *model_path) {
    ctx = whisper_init_from_file(model_path);
}

void whisper_stream(short *audio, int size) {

    if (!ctx) return;

    whisper_full_params params = whisper_full_default_params(WHISPER_SAMPLING_GREEDY);

    params.print_progress = false;
    params.print_realtime = false;

    whisper_full(ctx, params, (float *)audio, size);

    int n = whisper_full_n_segments(ctx);

    for (int i = 0; i < n; i++) {
        const char *text = whisper_full_get_segment_text(ctx, i);

        send_to_java(text);
    }
}