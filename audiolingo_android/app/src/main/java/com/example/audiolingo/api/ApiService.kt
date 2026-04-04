package com.example.audiolingo.api

import okhttp3.MultipartBody
import retrofit2.Call
import retrofit2.http.*

interface ApiService {

    @Multipart
    @POST("transcribe")
    fun transcribeAudio(
        @Part file: MultipartBody.Part
    ): Call<String>
}