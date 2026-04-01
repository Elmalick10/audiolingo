package com.example.audiolingo.repository

import com.example.audiolingo.network.ApiClient
import com.example.audiolingo.network.VideoRequest
import retrofit2.Call

class VideoRepository {

    fun generate(prompt: String): Call<*> {
        return ApiClient.instance.generateVideo(VideoRequest(prompt))
    }
}