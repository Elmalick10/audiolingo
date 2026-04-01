package com.example.audiolingo.network

import okhttp3.MultipartBody
import retrofit2.Call
import retrofit2.http.*

interface AvatarApi {

    @Multipart
    @POST("avatar")
    fun generateAvatar(
        @Part image: MultipartBody.Part,
        @Part audio: MultipartBody.Part
    ): Call<Map<String, String>>
}