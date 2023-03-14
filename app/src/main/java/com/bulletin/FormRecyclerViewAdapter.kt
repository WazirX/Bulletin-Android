package com.app.BitRabbit.Classes.Components.FormCollection

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bulletin.models.*
import com.bulletin.viewHolder.*
import com.example.bulletin.databinding.*
import com.wrx.wazirx.views.bulletin.model.Media


class FormRecyclerViewAdapter(var formSection: List<BulletinItem>) :
    RecyclerView.Adapter<BaseViewHolder<BulletinItem>>() {

    // region Variables
    private lateinit var listener : OnItemClickListener

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

        return if (item is Title) {
            ITEM_VIEW_TYPE_TITLE
        } else if (item is Message) {
            ITEM_VIEW_TYPE_MESSAGE
        } else if (item is Media) {
            ITEM_VIEW_TYPE_MEDIA
        } else if (item is BulletPoint) {
            ITEM_VIEW_TYPE_BULLET_POINT
        } else if (item is ActionButton) {
            ITEM_VIEW_TYPE_ACTION_BUTTON
        } else {
            ITEM_VIEW_TYPE_TITLE
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
    fun setListener(context : OnItemClickListener){
        listener = context
    }

    // endregion

    // region Interface Methods
    interface OnItemClickListener {
      //  fun formDidTriggerEvent(eventType: FormSectionBaseItem.EventType, baseItem : FormSectionBaseItem, index : Int) : Boolean
    }
    // endregion
}
