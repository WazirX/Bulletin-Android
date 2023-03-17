package com.bulletin

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bulletin.models.BulletinItem
import com.bulletin.viewHolder.*
import com.example.bulletin.databinding.*


class FormRecyclerViewAdapter(var formSection: List<BulletinItem>,var listener: OnItemClickListener) :
    RecyclerView.Adapter<BaseViewHolder<BulletinItem>>() {


    fun setRecyclerViewItems(formData: List<BulletinItem>) {
        formSection = formData
        notifyDataSetChanged()
    }

    // region RecyclerView Adapter Methods
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<BulletinItem> {

        // Based on the view type initilaize the viewholder
        when(viewType) {
            ITEM_VIEW_TYPE_TITLE -> {
                val view =
                    LayoutFormSectionTitleBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                return FormSectionTitleViewHolder(view,listener) as BaseViewHolder<BulletinItem>
            }
            ITEM_VIEW_TYPE_MESSAGE -> {
                val view =
                    LayoutFormSectionMessageBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                return FormSectionMessageViewHolder(view,listener) as BaseViewHolder<BulletinItem>
            }
            ITEM_VIEW_TYPE_MEDIA -> {
                val view =
                    LayoutFormSectionMediaBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                return FormSectionMediaViewHolder(view,listener) as BaseViewHolder<BulletinItem>
            }
            ITEM_VIEW_TYPE_ACTION_BUTTON -> {
                val view =
                    LayoutFormSectionActionButtonBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                return FormSectionActionButtonViewHolder(view,listener) as BaseViewHolder<BulletinItem>
            }
            ITEM_VIEW_TYPE_BULLET_POINT -> {
                val view =
                    LayoutFormBulletPointBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                return FormSectionBulletPointViewHolder(view,listener) as BaseViewHolder<BulletinItem>
            }
            else -> {
                val view =
                    LayoutFormSectionTitleBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                return FormSectionTitleViewHolder(view,listener) as BaseViewHolder<BulletinItem>
            }
        }
    }

    override fun getItemCount(): Int {
        // Item Count
        return formSection.size ?: 0
    }

    override fun onBindViewHolder(holder: BaseViewHolder<BulletinItem>, position: Int) {
        // Bind the viewholder
        holder.bind(formSection[position])
    }

    override fun getItemViewType(position: Int): Int {

        val item = formSection[position].also { }

//        return if (item is Title) {
//            ITEM_VIEW_TYPE_TITLE
//        } else if (item is Message) {
//            ITEM_VIEW_TYPE_MESSAGE
//        } else if (item is Media) {
//            ITEM_VIEW_TYPE_MEDIA
//        } else if (item is BulletPoint) {
//            ITEM_VIEW_TYPE_BULLET_POINT
//        } else if (item is ActionButton) {
//            ITEM_VIEW_TYPE_ACTION_BUTTON
//        } else {
//            ITEM_VIEW_TYPE_TITLE
//        }

        return when (item.type){
            BulletinItem.ItemType.UNDEFINED -> ITEM_VIEW_TYPE_TITLE
            BulletinItem.ItemType.TITLE -> ITEM_VIEW_TYPE_TITLE
            BulletinItem.ItemType.MESSAGE -> ITEM_VIEW_TYPE_MESSAGE
            BulletinItem.ItemType.MEDIA -> ITEM_VIEW_TYPE_MEDIA
            BulletinItem.ItemType.BULLET_POINT -> ITEM_VIEW_TYPE_BULLET_POINT
            BulletinItem.ItemType.ACTION_BUTTON -> ITEM_VIEW_TYPE_ACTION_BUTTON
        }
    }
    // endregion

    // region Constant Value For Adapter Class
    companion object {
        private const val ITEM_VIEW_TYPE_TITLE = 0
        private const val ITEM_VIEW_TYPE_MESSAGE = 1
        private const val ITEM_VIEW_TYPE_MEDIA = 2
        private const val ITEM_VIEW_TYPE_BULLET_POINT = 3
        private const val ITEM_VIEW_TYPE_ACTION_BUTTON = 4
    }
    // endregion

    // region Methods
//    fun setListener(context : OnItemClickListener){
//        listener = context
//    }

    // endregion

    // region Interface Methods
    interface OnItemClickListener {
        fun formDidTriggerEvent(eventType: BulletinItem.EventType, baseItem : BulletinItem, index : Int) : Boolean
    }
    // endregion
}
