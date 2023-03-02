package com.bulletin.utilities

import android.content.Context
import android.content.SharedPreferences
import com.bulletin.BulletinApp.Companion.applicationContext

//object AppStorageHelper {
//    private const val SHARED_PREFS_NAME = "Bulletin_Shared_Prefs"
//    private const val SHARED_PREFS_PARAMS_LATEST_APP_VERSION = "latest_app_version"
//
//    // App version
//    var lastAppVersion: String?
//        get() {
//            return if (AppStorageHelper[SHARED_PREFS_PARAMS_LATEST_APP_VERSION] == null) {
//                ""
//            } else {
//                AppStorageHelper[SHARED_PREFS_PARAMS_LATEST_APP_VERSION]
//            }
//        }
//        set(value) {
//            save(SHARED_PREFS_PARAMS_LATEST_APP_VERSION, value)
//        }
//
//    //region Shared Prefs methods
//    private val sharedPreferences: SharedPreferences
//        get() = applicationContext.getSharedPreferences(
//            SHARED_PREFS_NAME,
//            Context.MODE_PRIVATE
//        )
//
//    public fun save(key: String, value: String?) {
//        sharedPreferences.edit().putString(key, value).apply()
//    }
//
//    public operator fun get(key: String): String? {
//        return sharedPreferences.getString(key, null)
//    } //endregion
//}

object AppStorageHelper {

    private const val SHARED_PREFS_NAME = "Bulletin_Shared_Prefs"
    val shared: SharedPreferences = applicationContext.getSharedPreferences(SHARED_PREFS_NAME, Context.MODE_PRIVATE)

    inline fun SharedPreferences.edit(operation: (SharedPreferences.Editor) -> Unit) {
        val edit = edit()
        operation(edit)
        edit.apply()
    }

    var SharedPreferences.clearValue
        set(newValue) {
            edit {
                it.clear()
            }
        }
        get() = run { }
}