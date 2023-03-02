package com.bulletin.utilities

import com.bulletin.models.BulletinItem
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.wrx.wazirx.views.bulletin.model.Media


//object GsonHelper {
//    private var gsonBuilder: GsonBuilder? = null
//    private var gsonInstance: Gson? = null
//
//    private fun getGsonBuilder(): GsonBuilder {
//        if (gsonBuilder == null) {
//            gsonBuilder = GsonBuilder()
//            setupGsonBuilder()
//        }
//        return gsonBuilder as GsonBuilder
//    }
//
//    fun getGsonInstance(): Gson? {
//        if (gsonInstance == null) {
//            gsonInstance = getGsonBuilder().create()
//        }
//        return gsonInstance
//    }
//
//    private fun setupGsonBuilder() {
//        gsonBuilder!!.setDateFormat("yyyy-MM-dd'T'HH:mm:ss+Z")
//        gsonBuilder!!.enableComplexMapKeySerialization()
//
//        gsonBuilder!!.registerTypeAdapterFactory(Media.runtimeTypeAdapterFactory)
//        gsonBuilder!!.registerTypeAdapterFactory(BulletinItem.runtimeTypeAdapterFactory)
//    }
//
//}

object GsonHelper {

    private val gsonBuilder: GsonBuilder by lazy {
        val _gsonBuilder = GsonBuilder()
        _gsonBuilder.setDateFormat("yyyy-MM-dd'T'HH:mm:ss+Z")
        _gsonBuilder.enableComplexMapKeySerialization()
        setupGsonBuilder(_gsonBuilder)
        _gsonBuilder
    }

    val gsonInstance: Gson by lazy {
        gsonBuilder.create()
    }

    private fun setupGsonBuilder(gsonBuilder: GsonBuilder) {

        gsonBuilder.registerTypeAdapterFactory(Media.runtimeTypeAdapterFactory)
        gsonBuilder.registerTypeAdapterFactory(BulletinItem.runtimeTypeAdapterFactory)
    }

}
