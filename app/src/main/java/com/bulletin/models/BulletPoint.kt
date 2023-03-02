package com.bulletin.models

import com.google.gson.annotations.SerializedName

//data class BulletPoint(var bulletType: BulletType) : BulletinItem() {
//    enum class BulletType {
//        UNICODE,
//        IMAGE;
//    }
//    @SerializedName("title")
//    var title: String? = null;
//    @SerializedName("subtitle")
//    var subtitle: String? = null
//}

data class BulletPoint(var bullet: Bullet?, var titleText: String?, var subTitleText: String?) : BulletinItem() {

    companion object {

        @Suppress("UNCHECKED_CAST")
        fun init(attributes: Map<String, Any>): BulletPoint? {

            // Set Bullet
            val bulletObj = attributes["bullet"] as? Map<String, Any> ?: return null

            val bullet = Bullet.init(bulletObj) ?: return null

            // Set Title Text
            val titleText = (attributes["titleText"] as? String) ?: return null

            // Set SubTitle Text
            val subTitleText = (attributes["subTitleText"] as? String) ?: return null

            return BulletPoint(bullet, titleText, subTitleText)
        }
    }
}

data class Bullet(val bulletType: BulletType?, val unicode: String?, val imageUrl: String?) : BulletinItem() {

    enum class BulletType {
        UNICODE,
        IMAGE;
    }

    companion object {

        fun init(attributes: Map<String, Any>?): Bullet? {

            // Validation
            val attributesObj = attributes ?: return null

            // Set BulletType
            val bulletTypeString = (attributes["bulletType"] as? String) ?: return null

            // Set BulletType
            val bulletType = (BulletType.valueOf(bulletTypeString.uppercase()))

            var visualSymbol = ""
            var imageUrlString = ""

           when(bulletType) {
               BulletType.UNICODE -> {

                   // Set Unicode
                    visualSymbol = attributes["unicode"] as? String ?: return null
               }
               BulletType.IMAGE -> {

                   // Set ImageUrl
                    imageUrlString = attributes["imageUrl"] as? String ?: return null

               }
               else -> {
                    return null
               }
           }

            return Bullet(bulletType, visualSymbol, imageUrlString)

        }
    }


}
