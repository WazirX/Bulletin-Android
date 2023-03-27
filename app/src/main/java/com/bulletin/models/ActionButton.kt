package com.bulletin.models


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

            return ActionButton(title, clickPayload)
        }
    }
}
