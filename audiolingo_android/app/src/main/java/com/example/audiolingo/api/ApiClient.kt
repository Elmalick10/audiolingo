package com.example.audiolingo.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import okhttp3.Interceptor
import okhttp3.OkHttpClient

val client = OkHttpClient.Builder()
    .addInterceptor { chain ->
        val request = chain.request().newBuilder()

        // ⚠️ inject token
        val token = AuthManager.getToken(App.context)

        if (token != null) {
            request.addHeader("Authorization", "Bearer $token")
        }

        chain.proceed(request.build())
    }
    .build()

object ApiClient {

    // ⚠️ CHANGE selon environnement
    private const val BASE_URL = "http://10.0.2.2:8000/"

    val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val service: ApiService by lazy {
        retrofit.create(ApiService::class.java)
    }
}