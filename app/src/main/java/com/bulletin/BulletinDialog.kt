package com.example.bulletin

import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.util.Size
import android.view.*
import androidx.fragment.app.DialogFragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.bulletin.FormRecyclerViewAdapter
import com.bulletin.models.*
import com.bulletin.utilities.ThemeUtils
import com.bulletin.utilities.ViewUtil
import com.example.bulletin.databinding.BulletinDialogBinding
import com.wrx.wazirx.views.bulletin.model.Media
import java.util.*


class BulletinDialog(var bulletinInfo: ArrayList<BulletinItem> = ArrayList()) : DialogFragment() , FormRecyclerViewAdapter.OnItemClickListener {

    // region Variables
//    private lateinit var binding: BulletinDialogBinding
    private var _binding: BulletinDialogBinding? = null
    // This property is only valid between onCreateDialog and
    // onDestroyView.
    private val binding get() = _binding!!
    private lateinit var formRecyclerViewAdapter: FormRecyclerViewAdapter
    public var bulletinListener : BulletinListener? = null
 //   private var bulletinInfo: ArrayList<BulletinItem> = ArrayList()
    // endregion

    override fun onCreate(savedInstanceState: Bundle?) {
//        setStyle(STYLE_NO_TITLE, R.style.Theme_Transparent)

//        Window.setLayout(
//            WindowManager.LayoutParams.MATCH_PARENT,
//            WindowManager.LayoutParams.MATCH_PARENT);

        setStyle(STYLE_NO_TITLE, android.R.style.Theme_Black_NoTitleBar_Fullscreen)

      //  context?.setTheme(R.style.AppThemeBase_WhiteKnight)
        super.onCreate(savedInstanceState)

        setupClickEvent()

//         (intent.extras?.getSerializable("BulletinInfo") as? ArrayList<BulletinInfo>)?.let {
//             for (dict in it) {
//                 for (bulletinfo in dict.items) {
//                     bulletinInfo.add(bulletinfo)
//                 }
//             }
//
//        }


    }

//    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
//        _binding = DialogExampleBinding.inflate(LayoutInflater.from(context))
//        return AlertDialog.Builder(requireActivity())
//            .setView(binding.root)
//            .create()
//    }

    private fun setupClickEvent() {
        binding.goItButton.setOnClickListener { closeClicked() }
    }

    private fun closeClicked() {
        bulletinListener?.backButtonClick()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        super.onCreateView(inflater, container, savedInstanceState)
//        val view: View = inflater.inflate(R.layout.bulletin_dialog, container, false)
//        _binding = BulletinDialogBinding.inflate(LayoutInflater.from(context))
//        binding.listView.setBackgroundColor(ThemeUtils.getAttributedColor(R.attr.main_bg_surface_alt, binding.listView.context))
//        return view
        _binding = BulletinDialogBinding.inflate(inflater, container, false)
        val root: View = binding.root
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
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
        val layoutManager = LinearLayoutManager(context)
        layoutManager.orientation = LinearLayoutManager.VERTICAL
        binding.listView.setLayoutManager(layoutManager)

        formRecyclerViewAdapter = FormRecyclerViewAdapter(bulletinInfo,this)
        binding.listView.setAdapter(formRecyclerViewAdapter)
    }

    fun setUpItems() : ArrayList<BulletinItem> {
        val title = Title("Version " + "1.21",Color.RED,"In this update","loreum ipsum loreum ipsum loreum ipsum loreum ipsum loreum ipsum")

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

    fun setupButtonClickEvent() {
        binding.goItButton.setOnClickListener {
            // Back event need to handle
        }
    }

    override fun formDidTriggerEvent(
        eventType: BulletinItem.EventType,
        baseItem: BulletinItem,
        index: Int
    ): Boolean {
        bulletinListener?.onButtonClick("")
        return true
    }

    interface BulletinListener {
        fun onButtonClick(response: String)
        fun backButtonClick()
    }

}