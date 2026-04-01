package com.example.audiolingo

import android.app.Activity
import android.content.Context
import android.util.Log
import com.android.billingclient.api.*

class BillingManager(
    private val context: Context,
    private val activity: Activity
) : PurchasesUpdatedListener {

    private lateinit var billingClient: BillingClient

    private val TAG = "BillingManager"

    init {
        setupBillingClient()
    }

    private fun setupBillingClient() {
        billingClient = BillingClient.newBuilder(context)
            .setListener(this)
            .enablePendingPurchases()
            .build()

        billingClient.startConnection(object : BillingClientStateListener {
            override fun onBillingSetupFinished(result: BillingResult) {
                if (result.responseCode == BillingClient.BillingResponseCode.OK) {
                    Log.d(TAG, "Billing prêt ✅")
                }
            }

            override fun onBillingServiceDisconnected() {
                Log.d(TAG, "Billing déconnecté ❌")
            }
        })
    }

    // 🔥 Lancer achat abonnement
    fun startPurchase(productId: String) {
        val params = QueryProductDetailsParams.newBuilder()
            .setProductList(
                listOf(
                    QueryProductDetailsParams.Product.newBuilder()
                        .setProductId(productId)
                        .setProductType(BillingClient.ProductType.SUBS)
                        .build()
                )
            ).build()

        billingClient.queryProductDetailsAsync(params) { _, productDetailsList ->

            if (productDetailsList.isEmpty()) {
                Log.e(TAG, "Produit introuvable ❌")
                return@queryProductDetailsAsync
            }

            val productDetails = productDetailsList[0]

            val offerToken = productDetails.subscriptionOfferDetails
                ?.get(0)?.offerToken ?: return@queryProductDetailsAsync

            val billingFlowParams = BillingFlowParams.newBuilder()
                .setProductDetailsParamsList(
                    listOf(
                        BillingFlowParams.ProductDetailsParams.newBuilder()
                            .setProductDetails(productDetails)
                            .setOfferToken(offerToken)
                            .build()
                    )
                )
                .build()

            billingClient.launchBillingFlow(activity, billingFlowParams)
        }
    }

    // 🔥 Callback achat
    override fun onPurchasesUpdated(
        billingResult: BillingResult,
        purchases: MutableList<Purchase>?
    ) {
        if (billingResult.responseCode == BillingClient.BillingResponseCode.OK && purchases != null) {
            for (purchase in purchases) {
                handlePurchase(purchase)
            }
        } else {
            Log.e(TAG, "Achat échoué ❌")
        }
    }

    // 🔥 Gestion achat
    private fun handlePurchase(purchase: Purchase) {
        if (purchase.purchaseState == Purchase.PurchaseState.PURCHASED) {

            if (!purchase.isAcknowledged) {
                val acknowledgeParams = AcknowledgePurchaseParams.newBuilder()
                    .setPurchaseToken(purchase.purchaseToken)
                    .build()

                billingClient.acknowledgePurchase(acknowledgeParams) {
                    Log.d(TAG, "Achat confirmé ✅")
                }
            }
        }
    }

    // 🔥 Vérifier abonnement actif
    fun checkSubscription(callback: (Boolean) -> Unit) {

        billingClient.queryPurchasesAsync(
            QueryPurchasesParams.newBuilder()
                .setProductType(BillingClient.ProductType.SUBS)
                .build()
        ) { _, purchasesList ->

            val active = purchasesList.any {
                it.purchaseState == Purchase.PurchaseState.PURCHASED
            }

            callback(active)
        }
    }

    fun endConnection() {
        billingClient.endConnection()
    }
}