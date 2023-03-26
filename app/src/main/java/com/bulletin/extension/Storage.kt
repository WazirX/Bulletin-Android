package com.bulletin.extension

import android.content.SharedPreferences
import com.bulletin.models.Version
import com.bulletin.utilities.AppStorageHelper.edit

private const val SHARED_PREFS_PARAMS_LATEST_APP_VERSION = "latest_app_version"

var SharedPreferences.lastSeenVersion: Version?
    set(newValue) {
        edit {
            if (newValue == null) {
                it.remove(SHARED_PREFS_PARAMS_LATEST_APP_VERSION)
            } else {
                it.putString(SHARED_PREFS_PARAMS_LATEST_APP_VERSION, newValue.version.toString())
            }
        }
    }
    get() {
        val versionString = getString(SHARED_PREFS_PARAMS_LATEST_APP_VERSION, null) ?: return null
        return Version(versionString)
    }
