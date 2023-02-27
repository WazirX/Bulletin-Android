package com.bulletin.models

import com.google.gson.annotations.SerializedName

data class ActionButton(val title: String) : BulletinItem() {
    @SerializedName("clickPayload")
    var clickPayload: Any? = null
}
