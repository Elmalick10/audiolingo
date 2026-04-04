package com.example.audiolingo.billing

import android.app.Activity
import android.content.Intent
import android.net.Uri

class BillingManager(private val activity: Activity) {

    fun startGoogleSubscription() {
        println("💳 Google Billing lancé")
    }

    fun openPayPal() {
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.paypal.com"))
        activity.startActivity(intent)
    }

    fun openCinetPay() {
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://checkout.cinetpay.com"))
        activity.startActivity(intent)
    }
}