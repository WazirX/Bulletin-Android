package com.bulletin

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.content.ContextCompat
import com.bulletin.extension.lastSeenVersion
import com.bulletin.models.BulletinInfo
import com.bulletin.models.BulletinItem
import com.bulletin.utilities.AppStorageHelper
import com.example.bulletin.BulletinDialog
import com.example.bulletin.DefaultActivity
import com.example.bulletin.R


enum class Appearance(val value: String) {
    DARK("dark"),
    LIGHT("light");
}

object AppTheme {
    var appearance: Appearance = Appearance.DARK

    fun getCurrentTheme(): Int {

        return when (appearance) {
            Appearance.DARK -> R.style.AppThemeBase_DarkKnight
            Appearance.LIGHT -> R.style.AppThemeBase_WhiteKnight
        }
    }
}

class BulletinSdk(val dataStore: BulletinDataStore, val theme : Appearance) {

    fun getFullBulletin(context: Context,listner : BulletinDialog.BulletinListener) : BulletinDialog? {
        val items = dataStore.getData(null, null)
        return getBulletin(context, items,listner)
    }


    fun getLastBulletins(context: Context, limit: Int? = 1,listner : BulletinDialog.BulletinListener): BulletinDialog? {
        val items = dataStore.getData(null, null, limit)
        return getBulletin(context, items,listner)
    }

    fun getUnseenBulletin(context: Context, limit: Int? = null,listner : BulletinDialog.BulletinListener): BulletinDialog? {
        val lastseenVersion = AppStorageHelper.shared.lastSeenVersion ?: return null
        val items = dataStore.getData(lastseenVersion, null, limit)
        return getBulletin(context, items,listner)
    }

    fun getBulletin(context: Context,item: ArrayList<BulletinInfo>?, listner : BulletinDialog.BulletinListener): BulletinDialog? {
        if (item == null || item.isEmpty()) return null;

//        when (theme) {
//            Appearance.DARK -> AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
//            Appearance.LIGHT -> AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
//            Appearance.SYSTEM -> AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM)
//        }

        AppTheme.appearance = theme

//        val mainIntent = Intent(context, MainActivity::class.java)
//        val bundle = Bundle()
//        bundle.putSerializable("BulletinInfo", item)
//        mainIntent.putExtras(bundle)
//        startActivity(context, mainIntent, null)

        val bulletinItems: ArrayList<BulletinItem> = ArrayList()

        item.forEach { bulletItem ->
            for (bulletinItem in bulletItem.items) {
                bulletinItems.add(bulletinItem)
            }
        }

        val bulletinDialog = BulletinDialog(bulletinItems)
        bulletinDialog.bulletinListener = listner

        return bulletinDialog
    }

}