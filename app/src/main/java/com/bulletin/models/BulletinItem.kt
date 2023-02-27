package com.bulletin.models

import com.bulletin.utilities.RuntimeTypeAdapterFactory
import com.wrx.wazirx.views.bulletin.model.Media

abstract class BulletinItem()  {
    companion object {
        @JvmStatic
        val runtimeTypeAdapterFactory: RuntimeTypeAdapterFactory<*>
            get() {
                val mediaRuntimeTypeAdapterFactory = RuntimeTypeAdapterFactory.of(
                    BulletinItem::class.java, "type"
                )
                mediaRuntimeTypeAdapterFactory.registerSubtype(PreTitle::class.java, "preTitle")
                mediaRuntimeTypeAdapterFactory.registerSubtype(Title::class.java, "title")
                mediaRuntimeTypeAdapterFactory.registerSubtype(Message::class.java, "message")
                mediaRuntimeTypeAdapterFactory.registerSubtype(Media::class.java, "media")
                mediaRuntimeTypeAdapterFactory.registerSubtype(
                    BulletPoint::class.java,
                    "bulletPoint"
                )
                mediaRuntimeTypeAdapterFactory.registerSubtype(
                    ActionButton::class.java,
                    "actionButton"
                )
                return mediaRuntimeTypeAdapterFactory
            }

    }

    //endregion
    }
