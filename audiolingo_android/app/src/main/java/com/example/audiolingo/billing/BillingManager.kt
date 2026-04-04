package com.example.audiolingo.billing

import android.app.Activity
import com.android.billingclient.api.*

class BillingManager(private val activity: Activity) : PurchasesUpdatedListener {

    private val billingClient = BillingClient.newBuilder(activity)
        .setListener(this)
        .enablePendingPurchases()
        .build()

    private val PRODUCT_ID = "audiolingo_premium_monthly"

    fun startConnection(onReady: () -> Unit) {
        billingClient.startConnection(object : BillingClientStateListener {
            override fun onBillingSetupFinished(result: BillingResult) {
                if (result.responseCode == BillingClient.BillingResponseCode.OK) {
                    onReady()
                }
            }
            override fun onBillingServiceDisconnected() {}
        })
    }

    fun launchPurchaseFlow() {
        val params = QueryProductDetailsParams.newBuilder()
            .setProductList(
                listOf(
                    QueryProductDetailsParams.Product.newBuilder()
                        .setProductId(PRODUCT_ID)
                        .setProductType(BillingClient.ProductType.SUBS)
                        .build()
                )
            ).build()

        billingClient.queryProductDetailsAsync(params) { _, productDetailsList ->
            val productDetails = productDetailsList.firstOrNull() ?: return@queryProductDetailsAsync

            val offerToken = productDetails.subscriptionOfferDetails?.first()?.offerToken ?: return@queryProductDetailsAsync

            val billingFlowParams = BillingFlowParams.newBuilder()
                .setProductDetailsParamsList(
                    listOf(
                        BillingFlowParams.ProductDetailsParams.newBuilder()
                            .setProductDetails(productDetails)
                            .setOfferToken(offerToken)
                            .build()
                    )
                ).build()

            billingClient.launchBillingFlow(activity, billingFlowParams)
        }
    }

    override fun onPurchasesUpdated(result: BillingResult, purchases: MutableList<Purchase>?) {
        purchases?.forEach { purchase ->
            if (purchase.purchaseState == Purchase.PurchaseState.PURCHASED) {
                // 🔥 ACTIVER PREMIUM
                PremiumManager.setPremium(true)
            }
        }
    }
}