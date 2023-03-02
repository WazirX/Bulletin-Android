package com.bulletin

import com.bulletin.extension.lastSeenVersion
import com.bulletin.models.BulletinItem
import com.bulletin.models.BulletinVersion
import com.bulletin.models.Version
import com.bulletin.utilities.AppStorageHelper
import com.bulletin.utilities.VersionUtil
import java.util.*
import java.util.prefs.Preferences

object BulletinDataStore {
    var data: MutableList<BulletinVersion> = mutableListOf()
    fun registerVersionInfo(version: String, map: HashMap<String, Any>) {
        for ((key, value) in map) {

        }
    }

    fun registerVersionInfo(version: String, items: MutableList<BulletinItem>?) {
        if (items != null && items.isNotEmpty()) {
            data.add(BulletinVersion(version, items))
            Collections.sort(data, BulletinVersion.descendingSort)
        }
    }


    fun getData(
        fromNewVersion: Version?,
        toOldVersion: Version?,
        limit: Int? = null
    ): MutableList<BulletinVersion> {
        val finalMap: MutableList<BulletinVersion> = mutableListOf()

        if (fromNewVersion == null && toOldVersion == null && limit == null) {
            return data
        } else if (fromNewVersion == null && toOldVersion == null && limit != null) {
            return finalMap.take(limit).toMutableList()
        }

        val sortedList = data.sortedWith(compareBy({
            it.versionNumber
        }))

        for (indice in sortedList.indices) {

            if (indice == 0) AppStorageHelper.shared.lastSeenVersion = Version.init(sortedList[indice].versionNumber)
            if (VersionUtil.versionCompare(fromNewVersion?.version, sortedList[indice].versionNumber) >= 0) {
                finalMap.add(sortedList[indice])
            } else if (VersionUtil.versionCompare(toOldVersion?.version, sortedList[indice].versionNumber) < 0) {
                finalMap.add(sortedList[indice])
            }

            if (limit != null && finalMap.size >= limit) break

        }
        return finalMap
    }
}