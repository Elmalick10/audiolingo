package com.example.audiolingo.ai

object NCNNBridge {
    init {
        System.loadLibrary("ncnn")
    }

    external fun loadModel()
}