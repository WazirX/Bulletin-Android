package com.bulletin

import com.bulletin.extension.lastSeenVersion
import com.bulletin.models.BulletinInfo
import com.bulletin.models.BulletinItem
import com.bulletin.models.Version
import com.bulletin.utilities.AppStorageHelper
import com.bulletin.utilities.VersionUtil
import java.util.*

//object BulletinDataStore {
//    var data: MutableList<BulletinVersion> = mutableListOf()
//    fun registerVersionInfo(version: String, map: HashMap<String, Any>) {
//        for ((key, value) in map) {
//
//        }
//    }
//
//    fun registerVersionInfo(version: String, items: MutableList<BulletinItem>?) {
//        if (items != null && items.isNotEmpty()) {
//            data.add(BulletinVersion(version, items))
//            Collections.sort(data, BulletinVersion.descendingSort)
//        }
//    }
//
//
//    fun getData(
//        fromNewVersion: Version?,
//        toOldVersion: Version?,
//        limit: Int? = null
//    ): MutableList<BulletinVersion> {
//        val finalMap: MutableList<BulletinVersion> = mutableListOf()
//
//        if (fromNewVersion == null && toOldVersion == null && limit == null) {
//            return data
//        } else if (fromNewVersion == null && toOldVersion == null && limit != null) {
//            return finalMap.take(limit).toMutableList()
//        }
//
//        val sortedList = data.sortedWith(compareBy({
//            it.versionNumber
//        }))
//
//        for (indice in sortedList.indices) {
//
//            if (indice == 0) AppStorageHelper.shared.lastSeenVersion = Version.init(sortedList[indice].versionNumber)
//            if (VersionUtil.versionCompare(fromNewVersion?.version, sortedList[indice].versionNumber) >= 0) {
//                finalMap.add(sortedList[indice])
//            } else if (VersionUtil.versionCompare(toOldVersion?.version, sortedList[indice].versionNumber) < 0) {
//                finalMap.add(sortedList[indice])
//            }
//
//            if (limit != null && finalMap.size >= limit) break
//
//        }
//        return finalMap
//    }
//}

class BulletinDataStore {

    var data: MutableList<BulletinInfo> = mutableListOf()
        private set

    fun registerVersionInfo11(version: Version, items: MutableList<HashMap<String, Any>>) {

        val bulletinItems = ArrayList<BulletinItem>()
        for (itemAttributes in items)  {
            val bulletinItem = BulletinItem.createBulletinItem(itemAttributes) ?: return continue
            bulletinItems.add(bulletinItem)
        }

        registerVersionInfo(version, bulletinItems)
    }

    fun registerVersionInfo(version: Version, items: MutableList<BulletinItem>?) {

        if (items == null || items.isEmpty()) {
            return
        }

        // Create Bulletin Info Object
        val bulletinInfo = BulletinInfo.init(version, items)

        data.add(bulletinInfo)
        Collections.sort(data, BulletinInfo.descendingSort)
    }


    fun getData(
        fromNewVersion: Version?,
        toOldVersion: Version?,
        limit: Int? = null
    ): ArrayList<BulletinInfo> {
        //  val finalMap: MutableList<BulletinInfo> = mutableListOf()
        val bulletinInfo = arrayListOf<BulletinInfo>()

        if (fromNewVersion == null && toOldVersion == null && limit == null) {

            bulletinInfo.addAll(data)
            return bulletinInfo
        } else if (fromNewVersion == null && toOldVersion == null && limit != null) {
            bulletinInfo.addAll(data.take(limit))
            return  bulletinInfo
        }

        val sortedList = data.sortedWith(compareBy({
            it.version.version
        }))

        for (indice in sortedList.indices) {

            if (indice == 0) AppStorageHelper.shared.lastSeenVersion = Version.init(sortedList[indice].version.version)
            if (VersionUtil.versionCompare(fromNewVersion?.version, sortedList[indice].version.version) >= 0) {
                bulletinInfo.add(sortedList[indice])
            } else if (VersionUtil.versionCompare(toOldVersion?.version, sortedList[indice].version.version) < 0) {
                bulletinInfo.add(sortedList[indice])
            }

            if (limit != null && bulletinInfo.size >= limit) break

        }
        return bulletinInfo
    }
}