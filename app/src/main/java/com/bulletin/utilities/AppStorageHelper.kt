package com.bulletin.utilities

import android.content.Context
import android.content.SharedPreferences
import com.bulletin.BulletinApp.Companion.applicationContext

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