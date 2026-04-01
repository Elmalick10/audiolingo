package com.example.audiolingo.network

import retrofit2.Call
import retrofit2.http.*

data class VideoRequest(val prompt: String)
data class VideoResponse(val task_id: String)

interface ApiService {

    @POST("video")
    fun generateVideo(@Body request: VideoRequest): Call<VideoResponse>

    @Multipart
    @POST("upload")
    fun uploadImage(@Part image: okhttp3.MultipartBody.Part): Call<Void>
}