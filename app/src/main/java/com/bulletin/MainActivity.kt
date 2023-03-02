package com.example.bulletin

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bulletin.BulletinDataStore
import com.bulletin.BulletinSdk
import com.bulletin.extension.validVersion
import com.bulletin.models.ActionButton
import com.bulletin.models.BulletinItem
import com.bulletin.models.PreTitle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val value = "11".validVersion()

        val bulletinItem = PreTitle("text")
        val bulletinItem1 = ActionButton("actionButton","")
        val bulletinItem2 = bulletinItem.copy(text = "Hello")
        val bulletinItem3 = bulletinItem1.copy(title = "New Action button")
        val bulletinItem4 = bulletinItem.copy(text = "Hello boss")
        val bulletinItem5 = bulletinItem.copy(text = "Hello boss")
        val bulletinItemListTwo: MutableList<BulletinItem> = mutableListOf()

        bulletinItemListTwo.add(bulletinItem)
        bulletinItemListTwo.add(bulletinItem2)
        bulletinItemListTwo.add(bulletinItem3)
        bulletinItemListTwo.add(bulletinItem4)
        bulletinItemListTwo.add(bulletinItem5)

        BulletinDataStore.registerVersionInfo("1.0", bulletinItemListTwo)
        BulletinDataStore.registerVersionInfo("1.3", bulletinItemListTwo)
        BulletinDataStore.registerVersionInfo("1.4", bulletinItemListTwo)
        BulletinDataStore.registerVersionInfo("1.1", bulletinItemListTwo)
        BulletinDataStore.registerVersionInfo("1.2", bulletinItemListTwo)

        val items = BulletinSdk().showUnseenBulletin(4)

    }
}