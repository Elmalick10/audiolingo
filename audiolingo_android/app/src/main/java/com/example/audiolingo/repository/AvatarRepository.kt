package com.example.audiolingo.repository

import com.example.audiolingo.network.ApiClient
import okhttp3.MultipartBody
import retrofit2.Call

class AvatarRepository {

    fun generate(image: MultipartBody.Part, audio: MultipartBody.Part): Call<Map<String, String>> {
        return ApiClient.instance.generateAvatar(image, audio)
    }
}