package com.bulletin.extension

import com.google.gson.Gson

fun String.toJsonObj() : Any? {
    return toJsonObj(Any::class.java)
}

fun <T> String.toJsonObj(classOfT : Class<T>) : T? {
    try {
        return Gson().fromJson(this, classOfT)
    } catch (e : Throwable) {
        print("Json object conversion failed: $e")
    }
    return null
}

fun Any.toJsonString() : String? {
    try {
        return Gson().toJson(this)
    } catch (e : Throwable) {
        print("Json string conversion failed: $e")
    }
   return null
}


