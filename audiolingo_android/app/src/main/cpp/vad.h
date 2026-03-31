#pragma once

#include "vad.h"
#include <cmath>

bool isSpeech(float* audio, int size) {
    float energy = 0.0f;

    for (int i = 0; i < size; i++) {
        energy += audio[i] * audio[i];
    }

    energy /= size;

    return energy > 0.001f; // seuil ajustable
}