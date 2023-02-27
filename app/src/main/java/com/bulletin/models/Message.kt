package com.bulletin.models

import com.google.gson.annotations.SerializedName

data class Message(val message: String) : BulletinItem() {

    enum class MessageType(type: String) {
        HTML("html"),
        TEXT("text");
    }

    @SerializedName("imageType")
    var messageType: MessageType? = null

}
