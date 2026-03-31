package com.example.audiolingo.cloud

import com.google.firebase.storage.FirebaseStorage
import java.io.File

class CloudSync {

    private val storage = FirebaseStorage.getInstance()

    fun upload(file: File) {
        val ref = storage.reference.child("projects/${file.name}")
        ref.putFile(android.net.Uri.fromFile(file))
    }
}