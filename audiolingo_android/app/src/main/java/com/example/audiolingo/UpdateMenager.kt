package com.example.audiolingo.update

import com.google.android.play.core.appupdate.*

class UpdateManager {

    fun check(activity: Activity) {
        val manager = AppUpdateManagerFactory.create(activity)

        manager.appUpdateInfo.addOnSuccessListener {
            if (it.updateAvailability() == UpdateAvailability.UPDATE_AVAILABLE) {
                manager.startUpdateFlowForResult(
                    it,
                    AppUpdateType.IMMEDIATE,
                    activity,
                    100
                )
            }
        }
    }
}