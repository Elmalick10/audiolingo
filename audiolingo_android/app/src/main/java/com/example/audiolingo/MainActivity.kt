package com.example.audiolingo

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

import com.example.audiolingo.repository.VideoRepository
import com.example.audiolingo.ai.WhisperManager
import com.example.audiolingo.streaming.StreamingClient
import com.example.audiolingo.video.AvatarEngine

import java.io.File

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var repo: VideoRepository
    private lateinit var whisper: WhisperManager
    private lateinit var streamer: StreamingClient

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 🔧 INIT
        repo = VideoRepository()
        whisper = WhisperManager()
        streamer = StreamingClient()

        val promptInput = findViewById<EditText>(R.id.promptInput)
        val generateBtn = findViewById<Button>(R.id.generateBtn)
        val avatarEngine = AvatarEngine()

        // 🎬 GENERATE VIDEO
        generateBtn.setOnClickListener {

            val prompt = promptInput.text.toString()
            val image = File(filesDir, "face.jpg")
            val audio = File(filesDir, "voice.wav")
            val output = File(filesDir, "avatar.mp4")

                avatarEngine.generateAvatarVideo(image, audio, output)

            if (prompt.isEmpty()) {
                Log.e("Main", "Prompt vide")
                return@setOnClickListener
            }

            repo.generate(prompt)
                .enqueue(object : Callback<Any> {

                    override fun onResponse(call: Call<Any>, response: Response<Any>) {
                        Log.d("API", "Réponse vidéo: ${response.body()}")
                    }

                    override fun onFailure(call: Call<Any>, t: Throwable) {
                        Log.e("API", "Erreur: ${t.message}")
                    }
                })
        }

        // 🎙️ TEST WHISPER (exemple fichier local)
        testWhisper()

        // 📡 TEST STREAMING
        testStreaming()
    }

    // 🎙️ TRANSCRIPTION AUDIO
    private fun testWhisper() {

        try {
            val file = File(filesDir, "audio.wav")

            if (!file.exists()) {
                Log.e("Whisper", "Fichier audio introuvable")
                return
            if (!UserManager.canGenerate()) {
                Toast.makeText(this, "Passe en version PRO 🚀", Toast.LENGTH_LONG).show()
                return
}
            }

            whisper.transcribeAudio(file) { result ->
                runOnUiThread {
                    Log.d("Whisper", "Texte: $result")
                }
            }

        } catch (e: Exception) {
            Log.e("Whisper", "Erreur: ${e.message}")
        }
    }

    // 📡 STREAM AUDIO
    private fun testStreaming() {

        try {
            val fakeAudio = ByteArray(1024) // simulation audio

            streamer.sendAudioChunk(fakeAudio)

        } catch (e: Exception) {
            Log.e("Streaming", "Erreur: ${e.message}")
        }
    
    val imagePart = MultipartBody.Part.createFormData("image", file.name, requestFile)
    val audioPart = MultipartBody.Part.createFormData("audio", audioFile.name, audioRequest)

    AvatarRepository().generate(imagePart, audioPart)
    .enqueue(object : Callback<Map<String, String>> {

        override fun onResponse(call: Call<Map<String, String>>, response: Response<Map<String, String>>) {
            val url = response.body()?.get("video_url")
            Log.d("AVATAR", "Vidéo: $url")
        }

        override fun onFailure(call: Call<Map<String, String>>, t: Throwable) {
            Log.e("AVATAR", "Erreur: ${t.message}")
        }
    })
    }
}