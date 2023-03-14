package com.bulletin.viewHolder

import android.graphics.Color
import android.graphics.PorterDuff
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import android.os.Build
import android.view.LayoutInflater
import android.view.View
import androidx.core.content.ContextCompat
import com.app.BitRabbit.Classes.Components.FormCollection.FormRecyclerViewAdapter
import com.bulletin.models.BulletinItem
import com.bulletin.models.Message
import com.bulletin.utilities.ThemeUtils
import com.bumptech.glide.request.target.CustomTarget
import com.bumptech.glide.request.transition.Transition
import com.example.bulletin.R
import com.example.bulletin.databinding.LayoutFormSectionMessageBinding
import com.example.bulletin.databinding.LayoutFormSectionTitleBinding


class FormSectionMessageViewHolder(val viewBinding : LayoutFormSectionMessageBinding, listener : FormRecyclerViewAdapter.OnItemClickListener) :
    BaseViewHolder<Message>(viewBinding,listener) {

    // region Methods
     override fun bind(item: Message) {

        super.bind(item)

        when(item.messageType) {
            Message.MessageType.HTML -> {
                // Set Subttitle
                if (!item.text.isNullOrBlank()) {
                    viewBinding.messageLabel.text = item.text
                    viewBinding.messageLabel.setVisibility(View.VISIBLE)
                } else {
                    viewBinding.messageLabel.text = ""
                    viewBinding.messageLabel.setVisibility(View.GONE)
                }
            }
            Message.MessageType.TEXT -> {
                // Set Subttitle
                if (!item.text.isNullOrBlank()) {
                    viewBinding.messageLabel.text = item.text
                    viewBinding.messageLabel.setVisibility(View.VISIBLE)
                } else {
                    viewBinding.messageLabel.text = ""
                    viewBinding.messageLabel.setVisibility(View.GONE)
                }
            }
            else -> {
                viewBinding.messageLabel.text = ""
                viewBinding.messageLabel.setVisibility(View.GONE)
            }
        }

    }

    override fun getBackgroundView(): View? {
        return null
    }

    override fun updateAppearance() {
        super.updateAppearance()

        // Set Default Properties
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            viewBinding.messageLabel.setTextAppearance(R.style.base_semi_bold)
        } else {
            viewBinding.messageLabel.setTextAppearance(viewBinding.messageLabel.context, R.style.large_bold)
        }

        viewBinding.messageLabel.setTextColor(ThemeUtils.getAttributedColor(R.attr.brand_text_primary, viewBinding.messageLabel.context))
    }
    // endregion

}
