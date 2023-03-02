package com.bulletin

import android.app.Application
import android.content.Context
import android.content.pm.PackageManager
import android.util.Log
import com.bulletin.utilities.GsonHelper
import com.google.gson.Gson

class BulletinApp : Application() {
    private var gsonInstance: Gson? = null

    companion object {
        lateinit var shared: BulletinApp
            private set

        val applicationContext: Context
            get() {
                return shared.applicationContext
            }
    }

    //Initializer
    init {
        shared = this
        gsonInstance = GsonHelper.gsonInstance
    }

}