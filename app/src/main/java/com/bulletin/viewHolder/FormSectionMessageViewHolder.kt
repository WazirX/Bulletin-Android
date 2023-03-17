package com.bulletin.viewHolder

import android.os.Build
import android.text.Html
import android.view.View
import androidx.core.text.HtmlCompat
import com.bulletin.FormRecyclerViewAdapter
import com.bulletin.models.Message
import com.bulletin.utilities.ThemeUtils
import com.example.bulletin.R
import com.example.bulletin.databinding.LayoutFormSectionMessageBinding


class FormSectionMessageViewHolder(val viewBinding : LayoutFormSectionMessageBinding, listener : FormRecyclerViewAdapter.OnItemClickListener) :
    BaseViewHolder<Message>(viewBinding,listener) {

    // region Methods
     override fun bind(item: Message) {

        super.bind(item)


        when(item.messageType) {
            Message.MessageType.HTML -> {
                // Set Subttitle
                if (!item.text.isNullOrBlank()) {
                    val fromHtml = HtmlCompat.fromHtml(item.text, HtmlCompat.FROM_HTML_MODE_COMPACT)
                    viewBinding.messageLabel.text = fromHtml
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
            viewBinding.messageLabel.setTextAppearance(R.style.base_regular)
        } else {
            viewBinding.messageLabel.setTextAppearance(viewBinding.messageLabel.context, R.style.base_regular)
        }

        viewBinding.messageLabel.setTextColor(ThemeUtils.getAttributedColor(R.attr.main_text_primary, viewBinding.messageLabel.context))
    }
    // endregion

}
