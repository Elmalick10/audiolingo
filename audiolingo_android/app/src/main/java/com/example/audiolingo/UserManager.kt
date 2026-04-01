package com.example.audiolingo

object UserManager {

    var plan = "free"
    var videosUsed = 0

    fun canGenerate(): Boolean {
        return when (plan) {
            "free" -> videosUsed < 1
            "basic" -> videosUsed < 20
            "pro" -> true
            else -> false
        }
    }

    fun incrementUsage() {
        videosUsed++
    }
}