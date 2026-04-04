package com.example.audiolingo.network

import com.example.audiolingo.api.ApiClient
import okhttp3.*
import java.io.File

object AudioUploader {

    suspend fun sendAudio(file: File, lang: String): String {

        val requestFile = file.asRequestBody("audio/wav".toMediaType())
        val body = MultipartBody.Part.createFormData("file", file.name, requestFile)

        val langPart = lang.toRequestBody("text/plain".toMediaType())

        val response = ApiClient.service.uploadAudio(body, langPart)

        return response.body()?.get("output").toString()
    }
}