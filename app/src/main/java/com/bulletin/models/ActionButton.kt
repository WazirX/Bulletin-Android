package com.bulletin.models

import com.google.gson.annotations.SerializedName

//data class ActionButton(val title: String) : BulletinItem() {
//    @SerializedName("clickPayload")
//    var clickPayload: Any? = null
//}

data class ActionButton(val title: String?, var clickPayload: Any?) : BulletinItem() {

    // region Init Methods
    init {
        type = ItemType.ACTION_BUTTON
    }

    companion object {

        fun init(attributes: Map<String, Any>): ActionButton? {

            // Set Title
            val title = (attributes["title"] as? String) ?: return null

            // Set Click Payload
            val clickPayload = attributes["clickPayload"]

            return ActionButton(title,clickPayload)
        }
    }
}
