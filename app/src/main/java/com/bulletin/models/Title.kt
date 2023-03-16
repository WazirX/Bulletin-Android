package com.bulletin.models

import com.bulletin.extension.validVersion

//data class Title( val text: String) : BulletinItem() {
//
//}

data class Title(val preTitleText: String?, val titleText: String?, val subTitleText: String?) : BulletinItem() {

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


//class Title() : BulletinItem() {
//
//    var preTitleText: String? = null
//    var titleText: String? = null
//    var subTitleText: String? = null
//
//
//    // region Init Methods
//    init {
//        type = ItemType.TITLE
//    }
//
//    companion object {
//
//        fun init(attributes: Map<String, Any>): Title? {
//
//            // init the object
//            val obj = Title()
//
//            // Set PreTitle
//            obj.preTitleText = (attributes["preTitleText"] as? String) ?: return null
//
//            // Set Title
//            obj.titleText = (attributes["titleText"] as? String) ?: return null
//
//            // Set SubTitle
//            obj.subTitleText = (attributes["subTitleText"] as? String) ?: return null
//
//            return obj
//
//        }
//    }
//}