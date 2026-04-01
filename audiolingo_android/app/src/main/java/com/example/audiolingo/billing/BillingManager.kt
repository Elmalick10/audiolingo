package com.example.audiolingo.billing

import android.app.Activity
import com.android.billingclient.api.*

class BillingManager(private val activity: Activity) {

    private lateinit var billingClient: BillingClient

    fun initBilling(onConnected: () -> Unit) {

        billingClient = BillingClient.newBuilder(activity)
            .enablePendingPurchases()
            .setListener { purchases, _ ->
                purchases?.forEach { handlePurchase(it) }
            }
            .build()

        billingClient.startConnection(object : BillingClientStateListener {
            override fun onBillingSetupFinished(result: BillingResult) {
                if (result.responseCode == BillingClient.BillingResponseCode.OK) {
                    onConnected()
                }
            }

            override fun onBillingServiceDisconnected() {}
        })
    }

    fun launchSubscription(productId: String) {

        val params = QueryProductDetailsParams.newBuilder()
            .setProductList(
                listOf(
                    QueryProductDetailsParams.Product.newBuilder()
                        .setProductId(productId)
                        .setProductType(BillingClient.ProductType.SUBS)
                        .build()
                )
            ).build()

        billingClient.queryProductDetailsAsync(params) { _, products ->

            val productDetails = products.firstOrNull() ?: return@queryProductDetailsAsync

            val flowParams = BillingFlowParams.newBuilder()
                .setProductDetailsParamsList(
                    listOf(
                        BillingFlowParams.ProductDetailsParams.newBuilder()
                            .setProductDetails(productDetails)
                            .build()
                    )
                ).build()
                val url = "https://ton-backend.com/paypal"
                startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(url)))

            billingClient.launchBillingFlow(activity, flowParams)
        }
    }

    private fun handlePurchase(purchase: Purchase) {
        if (purchase.purchaseState == Purchase.PurchaseState.PURCHASED) {
            // 🔐 envoyer au backend pour validation
        }
    }
}