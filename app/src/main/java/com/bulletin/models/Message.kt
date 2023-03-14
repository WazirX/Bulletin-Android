package com.bulletin.models

import com.google.gson.annotations.SerializedName

//data class Message(val message: String) : BulletinItem() {
//
//    enum class MessageType(type: String) {
//        HTML("html"),
//        TEXT("text");
//    }
//
//    @SerializedName("imageType")
//    var messageType: MessageType? = null
//
//}

data class Message(var messageType: MessageType = MessageType.TEXT, val text: String?) : BulletinItem() {

    enum class MessageType(type: String) {
        HTML("html"),
        TEXT("text");
    }

    // region Init Methods
    init {
        type = ItemType.MESSAGE
    }

    companion object {
        fun init(attributes: Map<String, Any>): Message? {

            // Set Message Type
            var messageType = MessageType.TEXT
            val messasgeTypeString = attributes["messageType"] as? String
            if (!messasgeTypeString.isNullOrEmpty()) {
                (MessageType.valueOf(messasgeTypeString.uppercase())).let {
                    messageType = it
                }
            }

            // Set Text
            val text = (attributes["text"] as? String) ?: return null

            return Message(messageType, text)
        }
    }
}