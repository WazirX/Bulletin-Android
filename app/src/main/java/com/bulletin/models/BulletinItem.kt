package com.bulletin.models

import com.bulletin.utilities.RuntimeTypeAdapterFactory
import com.wrx.wazirx.views.bulletin.model.Media
import java.io.Serializable

abstract class BulletinItem() : Serializable {

    // MARK: - Declarations
    enum class ItemType(val value: String) {
        UNDEFINED("Undefined"),
        TITLE("title"),
        MESSAGE("message"),
        MEDIA("media"),
        BULLET_POINT("bulletPoint"),
        ACTION_BUTTON("actionButton"),
    }

    enum class EventType(val value: String) {
        TRIGGER_ACTION("triggerAppAction"),
    }

    // MARK: - Variables
    var type: ItemType = ItemType.UNDEFINED

    companion object {
        val runtimeTypeAdapterFactory: RuntimeTypeAdapterFactory<*>
            get() {
                val mediaRuntimeTypeAdapterFactory = RuntimeTypeAdapterFactory.of(
                    BulletinItem::class.java, "type"
                )
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

        // It Will Return Action Card Creatd With Proper Classes
        fun createBulletinItem(attributes: Map<String, Any>?): BulletinItem? {

            // Validation
            val attributes = attributes ?: return null

            // Validations
            val typeString = attributes["type"] as? String ?: return null
            val itemType = ItemType.valueOf(typeString) ?: return null
            if (itemType != ItemType.UNDEFINED) {
                return null
            }

            // Get Bulletin Item
//            itemType.classFromString() as? BulletinItem.ItemType {
//                return bulletinItem.init(attributes: attributes)
//            }
            return null
        }

    }

    //endregion
}
