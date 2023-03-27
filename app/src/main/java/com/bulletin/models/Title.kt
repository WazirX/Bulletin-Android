package com.bulletin.models


data class Title(val preTitleText: String?, val titleText: String?, val subTitleText: String?) :
    BulletinItem() {

    // region Init Methods
    init {
        type = ItemType.TITLE
    }

    companion object {

        fun init(attributes: Map<String, Any>): Title? {

            // Set PreTitle
            val preTitleText = (attributes["preTitleText"] as? String) ?: return null

            // Set Title
            val titleText = (attributes["titleText"] as? String) ?: return null

            // Set SubTitle
            val subTitleText = (attributes["subTitleText"] as? String) ?: return null

            return Title(preTitleText, titleText, subTitleText)
        }
    }
}
