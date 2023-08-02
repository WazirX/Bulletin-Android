package com.bulletin.models

import android.graphics.Color


data class Title(val preTitleText: String?,val preTitleTextColor: Int?, val titleText: String?, val subTitleText: String?) : BulletinItem() {

    // region Init Methods
    init {
        type = ItemType.TITLE
    }

    companion object {

        fun init(attributes: Map<String, Any>): Title? {

            // Set PreTitle
            val preTitleText = (attributes["preTitleText"] as? String) ?: return null

            // Set PreTitle Color
            val preTitleTextColor = (attributes["preTitleTextColor"] as? String) ?: return null
            val preTitleTextColor1 = Color.parseColor(preTitleTextColor)

            // Set Title
            val titleText = (attributes["titleText"] as? String) ?: return null

            // Set SubTitle
            val subTitleText = (attributes["subTitleText"] as? String) ?: return null

            return Title(preTitleText,preTitleTextColor1, titleText, subTitleText)
        }
    }
}
