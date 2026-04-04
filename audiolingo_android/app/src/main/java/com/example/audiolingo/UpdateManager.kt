package com.example.audiolingo

import android.app.Activity
import com.google.android.play.core.appupdate.*
import com.google.android.play.core.install.model.*

class UpdateManager(private val activity: Activity) {

    private val appUpdateManager = AppUpdateManagerFactory.create(activity)

    fun checkUpdate() {
        val appUpdateInfoTask = appUpdateManager.appUpdateInfo

        appUpdateInfoTask.addOnSuccessListener { info ->
            if (info.updateAvailability() == UpdateAvailability.UPDATE_AVAILABLE &&
                info.isUpdateTypeAllowed(AppUpdateType.IMMEDIATE)
            ) {
                appUpdateManager.startUpdateFlowForResult(
                    info,
                    AppUpdateType.IMMEDIATE,
                    activity,
                    1001
                )
            }
        }
    }
}