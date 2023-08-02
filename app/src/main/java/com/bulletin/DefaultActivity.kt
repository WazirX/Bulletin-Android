package com.example.bulletin

import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.util.Size
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.bulletin.AppTheme
import com.bulletin.Appearance
import com.bulletin.FormRecyclerViewAdapter
import com.bulletin.extension.textAppearence
import com.bulletin.models.*
import com.bulletin.utilities.ThemeUtils
import com.bulletin.utilities.ViewUtil
import com.example.bulletin.databinding.ActivityMainBinding
import com.wrx.wazirx.views.bulletin.model.Media

class DefaultActivity : AppCompatActivity(){

    // region Variables
    private lateinit var binding: ActivityMainBinding
    private lateinit var formRecyclerViewAdapter: FormRecyclerViewAdapter
    private var bulletinInfo: ArrayList<BulletinItem> = ArrayList()
    // endregion

    override fun onCreate(savedInstanceState: Bundle?) {

        when (AppTheme.appearance) {
            Appearance.DARK -> setTheme(R.style.AppThemeBase_DarkKnight)
            Appearance.LIGHT -> setTheme(R.style.AppThemeBase_WhiteKnight)
        }

        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

    //    binding.listView.setBackgroundColor(ThemeUtils.getAttributedColor(R.attr.main_bg_surface_alt, binding.listView.context))

        (intent.extras?.getSerializable("ABC") as? ArrayList<BulletinInfo>)?.let {
            for (dict in it) {
                for (bulletinfo in dict.items) {
                    bulletinInfo.add(bulletinfo)
                }
            }

        }

//        loadDisplayContent()
//        updateAppearance()
//        recyclerViewSetUp()
    }

//    fun loadDisplayContent() {
//     //   ViewUtil.addBounceEffect(binding.goItButton)
//        setupButtonClickEvent()
//    }

//    fun updateAppearance() {
//
//        binding.headerTitle.textAppearence(R.style.large_semi_bold)
//        binding.goItButton.textAppearence(R.style.base_bold)
//
//        binding.headerTitle.setTextColor(ThemeUtils.getAttributedColor(R.attr.main_navigation_onNavigation, binding.headerTitle.context))
//
//        binding.listView.setBackgroundColor(ThemeUtils.getAttributedColor(R.attr.main_bg_surface_alt, binding.listView.context))
//        binding.goItButton.setBackgroundColor(ThemeUtils.getAttributedColor(R.attr.brand_bg_primary, binding.goItButton.context))
//
//        ThemeUtils.applyThemeDrawable(binding.headerView, R.attr.main_navigation_bg)
//        ThemeUtils.applyThemeDrawable(binding.mainBackgroundView, R.attr.main_bg_surface_alt)
//
//    }

//    fun recyclerViewSetUp(){
//        val layoutManager = LinearLayoutManager(this)
//        layoutManager.orientation = LinearLayoutManager.VERTICAL
//        binding.listView.setLayoutManager(layoutManager)
//
//        formRecyclerViewAdapter = FormRecyclerViewAdapter(setUpItems(),this)
//        binding.listView.setAdapter(formRecyclerViewAdapter)
//    }

    fun setUpItems() : ArrayList<BulletinItem> {

        val title = Title("Version " + "1.21", Color.RED,"In this update","loreum ipsum loreum ipsum loreum ipsum loreum ipsum loreum ipsum")

        val message = Message(Message.MessageType.HTML,"<header>\n" +
                "  <h1>Harry Potter's House</h1>\n" +
                "  <p class=\"address\">\n" +
                "Privet Drive, 4<br>Little Whinging<br>Surrey<br>England<br>Great Britain\n" +
                "  </p>\n" +
                "</header>")

        val size = Size(700,500)
        val media = Media(Media.MediaType.IMAGE,"https://media.wazirx.com/test_resources/crypto_gifts.png",null)

        val bullet = Bullet(Bullet.BulletType.IMAGE,"\uD83D\uDE01","https://s3.amazonaws.com/p.hellopye.com/app_assets/dashboard_deposit/3x.png") //"\u00F6" //"&#9995"

        val bulletPoint = BulletPoint(bullet,"Vestibulum","Etiam porta sem malesuada magna mollis euismod.")

        val bulletPoint2 = BulletPoint(bullet,"Justo Condimentum","Sed posuere consectetur est at lobortis. Vivamus sagittis lacus vel augue laoreet rutrum faucibus dolor auctor.")

        val actionButton = ActionButton("Take me to Crypto Gifts",null)

        return arrayListOf(title, message) // media, bulletPoint, bulletPoint2, actionButton

    }

//    fun setupButtonClickEvent() {
//        binding.goItButton.setOnClickListener {
//            // Back event need to handle
//            finish()
//        }
//    }
//
//    override fun formDidTriggerEvent(
//        eventType: BulletinItem.EventType,
//        baseItem: BulletinItem,
//        index: Int
//    ): Boolean {
//        return true
//    }

}
