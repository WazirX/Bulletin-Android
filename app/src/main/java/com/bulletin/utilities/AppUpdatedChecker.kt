package com.bulletin.utilities

import com.bulletin.BulletinApp


object AppUpdatedChecker {

    enum class AppRunningState(val value: Int) {
        NORMAL(1),
        FRESHINSTALL(2),
        AFTERUPDATE(3);
    }

    var appRunningState = AppRunningState.NORMAL


    fun currentAppRunningState() {

        // Fetch Last Known App Version from User Defaults
        val lastKnownAppVersion: String? =
            AppStorageHelper.lastAppVersion // get(LAST_KNOWN_APP_VERSION_KEY);

        // Fetch Current App Version
        val currentAppVersion: String? = VersionUtil.getApplicationVersion()
        appRunningState = if (lastKnownAppVersion != null) {
            if (currentAppVersion == lastKnownAppVersion) {

                // App is running on Same Version
                AppRunningState.NORMAL
            } else {

                // App is running newer version then Last known App Version
                AppRunningState.AFTERUPDATE
            }
        } else {

            // App Running After Fresh Install
            AppRunningState.FRESHINSTALL
        }
    }

}