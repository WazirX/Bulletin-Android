package com.bulletin

import com.bulletin.models.BulletinItem
import com.bulletin.models.BulletinVersion
import com.bulletin.utilities.AppStorageHelper
import com.bulletin.utilities.VersionUtil
import java.util.*

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
        fromNewVersion: String?,
        toOldVersion: String?,
        limit: Int? = null
    ): MutableList<BulletinVersion> {
        val finalMap: MutableList<BulletinVersion> = mutableListOf()

        if (fromNewVersion == null && toOldVersion == null && limit == null) {
            return data
        } else if (fromNewVersion == null && toOldVersion == null && limit != null) {
            return finalMap.take(limit).toMutableList()
        }


        for (indice in data.indices) {

            if (indice == 0) AppStorageHelper.lastAppVersion = data[indice].versionNumber
            if (VersionUtil.versionCompare(fromNewVersion, data[indice].versionNumber) >= 0) {
                finalMap.add(data[indice])
            } else if (VersionUtil.versionCompare(toOldVersion, data[indice].versionNumber) < 0) {
                finalMap.add(data[indice])
            }

            if (limit != null && finalMap.size >= limit) break


        }
        return finalMap


    }
}