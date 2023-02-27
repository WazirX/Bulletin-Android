package com.bulletin

import com.bulletin.models.BulletinVersion
import com.bulletin.utilities.AppStorageHelper

class BulletinSdk {

    fun showFullBulletin() : Boolean{
        val items = BulletinDataStore.getData(null, null)
        return showBulletin(items)
    }

    fun showLastBulletins(limit: Int? = 1): Boolean {
        val items = BulletinDataStore.getData(null, null, limit)
        return showBulletin(items)
    }

    fun showUnseenBulletin(limit: Int? = null): Boolean {
        val lastseenVersion = AppStorageHelper.lastAppVersion
        val items = BulletinDataStore.getData(null, "1.2", limit)
        return showBulletin(items)
    }

    fun showBulletin(item: MutableList<BulletinVersion>?): Boolean {
        if (item == null || item.isEmpty()) return false;

        return true
    }

}