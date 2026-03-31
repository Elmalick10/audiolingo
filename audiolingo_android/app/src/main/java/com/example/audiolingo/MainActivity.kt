package com.example.audiolingo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.audiolingo.video.VideoEditor

lateinit var ttsManager: com.example.audiolingo.ai.TTSManager

class MainActivity : AppCompatActivity() {

    companion object {
        init {
            System.loadLibrary("native-lib")
            System.loadLibrary("audiolingo_core")
        }
    }
    fun isPremium(): Boolean {
        return sharedPreferences.getBoolean("premium", false)
    }
    fun generateTalkingPhoto() {

    val url = "http://TON_SERVER/talking-photo"

    // upload image + texte
}
    val subtitleView = findViewById<com.example.audiolingo.ui.SubtitleView>(R.id.subtitleView)

        subtitleView.setSubtitle("Bonjour, test sous-titre en direct")

    val webView = findViewById<WebView>(R.id.webview)
        webView.settings.javaScriptEnabled = true
        webView.loadUrl("http://192.168.1.100:5000/live")

    external fun stringFromJNI(): String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ttsManager = TTSManager(this)

        println(stringFromJNI())
    
    
    ttsManager.speak("Bonjour, AudioLingo est prêt")
    ttsManager.setLanguage(Locale.FRANCE)
    ttsManager.stop()
    override fun onDestroy() {
    super.onDestroy()
    ttsManager.shutdown()
        }
    }
}