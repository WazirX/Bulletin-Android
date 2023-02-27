package com.wrx.wazirx.views.bulletin.model

import com.bulletin.models.BulletinItem
import com.bulletin.utilities.RuntimeTypeAdapterFactory
import com.google.gson.annotations.SerializedName


open class Media() : BulletinItem() {

    @SerializedName("imageType")
    lateinit var imageType: String
    @SerializedName("size")
    var size: Int = 0
    @SerializedName("url")
    lateinit var url: String

    companion object {
        @JvmStatic
        val runtimeTypeAdapterFactory: RuntimeTypeAdapterFactory<*>
            get() {
                val mediaRuntimeTypeAdapterFactory = RuntimeTypeAdapterFactory.of(
                    Media::class.java, "type"
                )
                mediaRuntimeTypeAdapterFactory.registerSubtype(ImageMedia::class.java, "Image")
                return mediaRuntimeTypeAdapterFactory
            }
    }
}

class ImageMedia(val versionNumber :String) : Media() {

}
