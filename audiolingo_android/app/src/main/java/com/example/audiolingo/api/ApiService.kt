package com.example.audiolingo.api

import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Response
import retrofit2.http.*

interface ApiService {

    @POST("ai/process")
    suspend fun processText(
        @Body body: Map<String, String>
    ): Response<Map<String, Any>>

    @Multipart
    @POST("ai/audio")
    suspend fun uploadAudio(
        @Part file: MultipartBody.Part,
        @Part("lang") lang: RequestBody
    ): Response<Map<String, Any>>

    @POST("login")
    suspend fun login(
    @Body body: Map<String, String>
    ): Response<Map<String, String>>

    @POST("register")
    suspend fun register(
    @Body body: Map<String, String>
    ): Response<Map<String, String>>
}