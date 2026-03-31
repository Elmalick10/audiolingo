package com.example.audiolingo.network

import okhttp3.*

class CinetPayApi {

    private val client = OkHttpClient()

    fun createPayment(amount: Int) {

        val body = RequestBody.create(null, """
            {
                "amount": $amount
            }
        """.trimIndent())

        val request = Request.Builder()
            .url("https://api.cinetpay.com/payment")
            .post(body)
            .build()

        client.newCall(request).execute()
    }
}