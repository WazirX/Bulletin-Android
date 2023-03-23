package com.bulletin

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.content.ContextCompat
import com.bulletin.extension.lastSeenVersion
import com.bulletin.models.BulletinInfo
import com.bulletin.utilities.AppStorageHelper
import com.example.bulletin.MainActivity

//enum class Appearance(val value: String) {
//    DARK("dark"),
//    LIGHT("light"),
//    SYSTEM("system");
//}
//
//class BulletinSdk(val theme : Appearance) {
//
//    init {
//        when (theme) {
//            Appearance.DARK -> AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
//            Appearance.LIGHT -> AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
//            Appearance.SYSTEM -> AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM)
//        }
//    }
//
//    fun showFullBulletin() : Boolean{
//        val items = BulletinDataStore.getData(null, null)
//        return showBulletin(items)
//    }
//
//    fun showLastBulletins(limit: Int? = 1): Boolean {
//        val items = BulletinDataStore.getData(null, null, limit)
//        return showBulletin(items)
//    }
//
//    fun showUnseenBulletin(limit: Int? = null): Boolean {
//        val lastseenVersion = AppStorageHelper.shared.lastSeenVersion ?: return false
//        val items = BulletinDataStore.getData(lastseenVersion, null, limit)
//        return showBulletin(items)
//    }
//
//    fun showBulletin(item: MutableList<BulletinVersion>?): Boolean {
//        if (item == null || item.isEmpty()) return false;
//
//        return true
//    }
//
//}

enum class Appearance(val value: String) {
    DARK("dark"),
    LIGHT("light"),
    SYSTEM("system");
}

class BulletinSdk(val dataStore: BulletinDataStore, val theme : Appearance) {

    fun showFullBulletin(context: Context) : Boolean {
        val items = dataStore.getData(null, null)
        return showBulletin(context, items)
    }

    fun showLastBulletins(context: Context, limit: Int? = 1): Boolean {
        val items = dataStore.getData(null, null, limit)
        return showBulletin(context, items)
    }

    fun showUnseenBulletin(context: Context, limit: Int? = null): Boolean {
        val lastseenVersion = AppStorageHelper.shared.lastSeenVersion ?: return false
        val items = dataStore.getData(lastseenVersion, null, limit)
        return showBulletin(context, items)
    }

    fun showBulletin(context: Context, item: ArrayList<BulletinInfo>?): Boolean {
        if (item == null || item.isEmpty()) return false;


        when (theme) {
            Appearance.DARK -> AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            Appearance.LIGHT -> AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
            Appearance.SYSTEM -> AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM)
        }

        val mainIntent = Intent(context, MainActivity::class.java)
        val bundle = Bundle()
        bundle.putSerializable("BulletinInfo", item)
        mainIntent.putExtras(bundle)
        ContextCompat.startActivity(context, mainIntent, null)
        return true
    }

}