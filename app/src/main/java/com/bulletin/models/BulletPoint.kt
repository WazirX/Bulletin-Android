package com.bulletin.models

import com.google.gson.annotations.SerializedName

data class BulletPoint(var bulletType: BulletType) : BulletinItem() {
    enum class BulletType {
        UNICODE,
        IMAGE;
    }
    @SerializedName("title")
    var title: String? = null;
    @SerializedName("subtitle")
    var subtitle: String? = null
}


