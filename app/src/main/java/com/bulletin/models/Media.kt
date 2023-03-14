package com.wrx.wazirx.views.bulletin.model

import android.util.Size
import com.bulletin.models.BulletinItem
import com.bulletin.models.Message
import com.bulletin.utilities.RuntimeTypeAdapterFactory
import com.google.gson.annotations.SerializedName


open class Media(var mediaType: MediaType = MediaType.IMAGE, val url: String?, val size: Size?) : BulletinItem() {

//    @SerializedName("imageType")
//    lateinit var imageType: String
//    @SerializedName("size")
//    var size: Int = 0
//    @SerializedName("url")
//    lateinit var url: String

    // region Init Methods
    init {
        type = BulletinItem.ItemType.MEDIA
    }

    enum class MediaType(val value: String) {
        IMAGE("image"),
    }

    companion object {

        val runtimeTypeAdapterFactory: RuntimeTypeAdapterFactory<*>
            get() {
                val mediaRuntimeTypeAdapterFactory = RuntimeTypeAdapterFactory.of(
                    Media::class.java, "type"
                )
               // mediaRuntimeTypeAdapterFactory.registerSubtype(ImageMedia::class.java, "Image")
                return mediaRuntimeTypeAdapterFactory
            }

            fun init(attributes: Map<String, Any>): Media? {
                // Set Media Type
                val mediaTypeString = attributes["mediaType"] as? String
                var mediaType = MediaType.IMAGE
                if (!mediaTypeString.isNullOrEmpty()) {
                    (MediaType.valueOf(mediaTypeString.uppercase())).let {
                        mediaType = it
                    }
                }

                // Set Url
                val urlString = (attributes["url"] as? String) ?: return null

                var size: Size? = null

                // Set Size
                val width = (attributes["width"] as? Float)?.toInt()
                val height = (attributes["height"] as? Float)?.toInt()
                size = width?.let { height?.let { it1 -> Size(it, it1) } }

                return Media(mediaType, urlString, size)
            }
    }
}

//class ImageMedia(val versionNumber :String) : Media() {
//
//}
