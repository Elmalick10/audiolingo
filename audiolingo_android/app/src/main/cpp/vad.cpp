bool detect_voice(short *audio, int size) {

    long energy = 0;

    for (int i = 0; i < size; i++) {
        energy += audio[i] * audio[i];
    }

    energy /= size;

    return energy > 500; // 🔥 seuil à ajuster
}