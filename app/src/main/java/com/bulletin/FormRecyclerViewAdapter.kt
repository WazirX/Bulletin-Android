//package com.app.BitRabbit.Classes.Components.FormCollection
//
//import android.view.LayoutInflater
//import android.view.ViewGroup
//import androidx.recyclerview.widget.RecyclerView
//import com.app.BitRabbit.Classes.Components.FormCollection.Views.*
//import com.bulletin.models.BulletinItem
//
//
//class FormRecyclerViewAdapter(var formSection: List<BulletinItem>) :
//    RecyclerView.Adapter<BaseViewHolder<BulletinItem>>() {
//
//    // region Variables
//    private lateinit var listener : OnItemClickListener
//
//    fun setRecyclerViewItems(formData: List<BulletinItem>) {
//        formSection = formData
//        notifyDataSetChanged()
//    }
//
//    // region RecyclerView Adapter Methods
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<BulletinItem> {
//
//        // Based on the view type initilaize the viewholder
//        when(viewType) {
//            ITEM_VIEW_TYPE_TITLE -> {
//                val view =
//                    LayoutFormSectionBigTitleItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
//                return FormSectionTitleViewHolder(view,listener) as BaseViewHolder<BulletinItem>
//            }
//            ITEM_VIEW_TYPE_MESSAGE -> {
//                val view =
//                    LayoutFormSectionDefaultItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
//                return FormSectionMessageViewHolder(view,listener) as BaseViewHolder<BulletinItem>
//            }
//            ITEM_VIEW_TYPE_MEDIA -> {
//                val view =
//                    LayoutFormSectionEditTextItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
//                return FormSectionMediaViewHolder(view,listener) as BaseViewHolder<BulletinItem>
//            }
//            ITEM_VIEW_TYPE_ACTION_BUTTON -> {
//                val view =
//                    LayoutFormSectionBigTitleItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
//                return FormSectionActionButtonViewHolder(view,listener) as BaseViewHolder<BulletinItem>
//            }
//            ITEM_VIEW_TYPE_BULLET_POINT -> {
//                val view =
//                    LayoutFormSectionAppInfoBinding.inflate(LayoutInflater.from(parent.context), parent, false)
//                return FormSectionBulletPointViewHolder(view,listener) as BaseViewHolder<FormSectionBaseItem>
//            }
//            else -> {
//                val view =
//                    LayoutFormSectionBigTitleItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
//                return FormSectionBigTitleItemViewHolder(view,listener) as BaseViewHolder<FormSectionBaseItem>
//            }
//        }
//    }
//
//    override fun getItemCount(): Int {
//        // Item Count
//        return formSection.size ?: 0
//    }
//
//    override fun onBindViewHolder(holder: BaseViewHolder<FormSectionBaseItem>, position: Int) {
//        // Bind the viewholder
//        holder.bind(formSection[position])
//    }
//
//    override fun getItemViewType(position: Int): Int {
//
//        val item = formSection[position].also { }
//
//        return when (item.type){
//            BIGTITLE -> ITEM_VIEW_TYPE_BIGTITLE
//            DEFAULT -> ITEM_VIEW_TYPE_DEFAULT
//            TEXT_FIELD -> ITEM_VIEW_TYPE_TEXTFIELD
//            TEXT_VIEW -> ITEM_VIEW_TYPE_TEXTVIEW
//            APP_INFO -> ITEM_VIEW_TYPE_APPINFO
//            STATUS_MESSAGE -> ITEM_VIEW_TYPE_STATUS_MESSAGE
//            ACCOUNT_BALANCE -> ITEM_VIEW_TYPE_ACCOUNT_BALANCE
//            ACCOUNT -> ITEM_VIEW_TYPE_ACCOUNT
//            WALLET -> ITEM_VIEW_TYPE_WALLET
//            COIN_NETWORK -> ITEM_VIEW_TYPE_COIN_NETWORK
//            WITHDRAW_AMOUNT_FIELD -> ITEM_VIEW_TYPE_WITHDRAW_AMOUNT_FIELD
//            ADDRESS_FIELD -> ITEM_VIEW_TYPE_ADDRESS_FIELD
//            ZERO_TRANSACTION -> ITEM_VIEW_TYPE_ZERO_TRANSACTION
//            TRANSACTION -> ITEM_VIEW_TYPE_TRANSACTION
//            WALLET_TRANSACTIONS_FOOTER -> ITEM_VIEW_TYPE_WALLET_TRANSACTIONS_FOOTER
//            RPC_NETWORK -> ITEM_VIEW_TYPE_RPC_NETWORK
//            RPC_NETWORK_INFO -> ITEM_VIEW_TYPE_RPC_NETWORK_INFO
//            HEADER -> ITEM_VIEW_TYPE_HEADER
//            FOOTER -> ITEM_VIEW_TYPE_FOOTER
//        }
//    }
//    // endregion
//
//    // region Constant Value For Adapter Class
//    companion object {
//        private const val ITEM_VIEW_TYPE_TITLE = 0
//        private const val ITEM_VIEW_TYPE_MESSAGE = 1
//        private const val ITEM_VIEW_TYPE_MEDIA = 2
//        private const val ITEM_VIEW_TYPE_BULLET_POINT = 3
//        private const val ITEM_VIEW_TYPE_ACTION_BUTTON = 4
//    }
//    // endregion
//
//    // region Methods
//    fun setListener(context : OnItemClickListener){
//        listener = context
//    }
//
//    // endregion
//
//    // region Interface Methods
//    interface OnItemClickListener {
//        fun formDidTriggerEvent(eventType: FormSectionBaseItem.EventType, baseItem : FormSectionBaseItem, index : Int) : Boolean
//    }
//    // endregion
//}
