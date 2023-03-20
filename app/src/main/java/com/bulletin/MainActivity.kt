package com.example.bulletin

import android.os.Build
import android.os.Bundle
import android.util.Size
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.bulletin.BulletinSdk
import com.bulletin.FormRecyclerViewAdapter
import com.bulletin.models.*
import com.bulletin.utilities.ThemeUtils
import com.bulletin.utilities.ViewUtil
import com.example.bulletin.databinding.ActivityMainBinding
import com.wrx.wazirx.views.bulletin.model.Media

class MainActivity : AppCompatActivity(), FormRecyclerViewAdapter.OnItemClickListener {

    // region Variables
    private lateinit var binding: ActivityMainBinding
    private lateinit var formRecyclerViewAdapter: FormRecyclerViewAdapter
    // endregion

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.listView.setBackgroundColor(ThemeUtils.getAttributedColor(R.attr.main_bg_surface_alt, binding.listView.context))

        loadDisplayContent()
        updateAppearance()
        recyclerViewSetUp()
    }

    fun loadDisplayContent() {
        ViewUtil.addBounceEffect(binding.goItButton)
        setupButtonClickEvent()
    }

    fun updateAppearance() {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            binding.headerTitle.setTextAppearance(R.style.large_semi_bold)
            binding.goItButton.setTextAppearance(R.style.base_bold)
        } else {
            binding.headerTitle.setTextAppearance(binding.headerTitle.context,R.style.large_semi_bold)
            binding.goItButton.setTextAppearance(binding.goItButton.context,R.style.base_bold)
        }

        binding.headerTitle.setTextColor(ThemeUtils.getAttributedColor(R.attr.main_navigation_onNavigation, binding.headerTitle.context))

        binding.listView.setBackgroundColor(ThemeUtils.getAttributedColor(R.attr.main_bg_surface_alt, binding.listView.context))
        binding.goItButton.setBackgroundColor(ThemeUtils.getAttributedColor(R.attr.brand_bg_primary, binding.goItButton.context))

        ThemeUtils.applyThemeDrawable(binding.headerView, R.attr.main_navigation_bg)
        ThemeUtils.applyThemeDrawable(binding.mainBackgroundView, R.attr.main_bg_surface_alt)

    }

    fun recyclerViewSetUp(){
        val layoutManager = LinearLayoutManager(this)
        layoutManager.orientation = LinearLayoutManager.VERTICAL
        binding.listView.setLayoutManager(layoutManager)

        formRecyclerViewAdapter = FormRecyclerViewAdapter(setUpItems(),this)
//        formRecyclerViewAdapter.setListener(this)
        binding.listView.setAdapter(formRecyclerViewAdapter)
    }

    fun setUpItems() : ArrayList<BulletinItem> {
//        val bulletinItem = PreTitle("text")
//        val bulletinItem1 = ActionButton("actionButton","")
//        val bulletinItem2 = bulletinItem.copy(text = "Hello")
//        val bulletinItem3 = bulletinItem1.copy(title = "New Action button")
//        val bulletinItem4 = bulletinItem.copy(text = "Hello boss")
//        val bulletinItem5 = bulletinItem.copy(text = "Hello boss")
//        val bulletinItemListTwo: MutableList<BulletinItem> = mutableListOf()
//
//        bulletinItemListTwo.add(bulletinItem)
//        bulletinItemListTwo.add(bulletinItem2)
//        bulletinItemListTwo.add(bulletinItem3)
//        bulletinItemListTwo.add(bulletinItem4)
//        bulletinItemListTwo.add(bulletinItem5)
//
//        BulletinDataStore.registerVersionInfo("1.0", bulletinItemListTwo)
//        BulletinDataStore.registerVersionInfo("1.3", bulletinItemListTwo)
//        BulletinDataStore.registerVersionInfo("1.4", bulletinItemListTwo)
//        BulletinDataStore.registerVersionInfo("1.1", bulletinItemListTwo)
//        BulletinDataStore.registerVersionInfo("1.2", bulletinItemListTwo)
//
        val items = BulletinSdk().showUnseenBulletin(4)


        val title = Title("Version " + "1.21","In this update","loreum ipsum loreum ipsum loreum ipsum loreum ipsum loreum ipsum")

        val message = Message(Message.MessageType.HTML,"<header>\n" +
                "  <h1>Harry Potter's House</h1>\n" +
                "  <p class=\"address\">\n" +
                "Privet Drive, 4<br>Little Whinging<br>Surrey<br>England<br>Great Britain\n" +
                "  </p>\n" +
                "</header>")

//        val size = Size(700,500)
//        val media = Media(Media.MediaType.IMAGE,"https://media.istockphoto.com/id/517188688/photo/mountain-landscape.jpg?s=612x612&w=0&k=20&c=A63koPKaCyIwQWOTFBRWXj_PwCrR4cEoOw2S9Q7yVl8=",null)
//
//        val bullet = Bullet(Bullet.BulletType.UNICODE,"\uD83D\uDE01",null) //"\u00F6" //"&#9995"
//
//        val bulletPoint = BulletPoint(bullet,"Vestibulum","Etiam porta sem malesuada magna mollis euismod.")
//
//        val bulletPoint2 = BulletPoint(bullet,"Justo Condimentum","Sed posuere consectetur est at lobortis. Vivamus sagittis lacus vel augue laoreet rutrum faucibus dolor auctor.")
//
//        val actionButton = ActionButton("Take me to Crypto Gifts",null)

        return arrayListOf(title, message) // media, bulletPoint, bulletPoint2, actionButton

    }

    fun setupButtonClickEvent() {
        binding.goItButton.setOnClickListener {
            // Back event need to handle
            finish()
        }
    }

    override fun formDidTriggerEvent(
        eventType: BulletinItem.EventType,
        baseItem: BulletinItem,
        index: Int
    ): Boolean {
        return true
    }


}