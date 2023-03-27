package com.bulletin.viewHolder

import android.content.res.ColorStateList
import android.view.View
import com.bulletin.FormRecyclerViewAdapter
import com.bulletin.extension.textAppearence
import com.bulletin.models.ActionButton
import com.bulletin.models.BulletinItem
import com.bulletin.utilities.DeviceUtil
import com.bulletin.utilities.ThemeUtils
import com.bulletin.utilities.ViewUtil
import com.example.bulletin.R
import com.example.bulletin.databinding.LayoutFormSectionActionButtonBinding


class FormSectionActionButtonViewHolder(
    val viewBinding: LayoutFormSectionActionButtonBinding,
    listener: FormRecyclerViewAdapter.OnItemClickListener
) :
    BaseViewHolder<ActionButton>(viewBinding, listener) {

    // region Methods
    override fun bind(item: ActionButton) {
        super.bind(item)

        // Set Title
        if (!item.title.isNullOrBlank()) {
            viewBinding.actionButton.text = item.title
            viewBinding.actionButton.setVisibility(View.VISIBLE)
        } else {
            viewBinding.actionButton.text = ""
            viewBinding.actionButton.setVisibility(View.GONE)
        }

        viewBinding.actionButton.setOnClickListener {
            _listener?.formDidTriggerEvent(
                BulletinItem.EventType.TRIGGER_ACTION,
                item,
                adapterPosition
            )
        }

        ViewUtil.addBounceEffect(viewBinding.actionButton)

    }

    override fun getBackgroundView(): View? {
        return null
    }

    override fun updateAppearance() {
        super.updateAppearance()

        viewBinding.actionButton.textAppearence(R.style.base_semi_bold)

        viewBinding.actionButton.setTextColor(
            ThemeUtils.getAttributedColor(
                R.attr.brand_text_primary,
                viewBinding.actionButton.context
            )
        )
        viewBinding.actionButton.setBackgroundColor(
            ThemeUtils.getAttributedColor(
                R.attr.main_bg_surface_alt,
                viewBinding.actionButton.context
            )
        )

        viewBinding.actionButton.strokeWidth =
            DeviceUtil.convertDpToPixel(viewBinding.actionButton.context, 1f)
        viewBinding.actionButton.setStrokeColor(
            ColorStateList.valueOf(
                ThemeUtils.getAttributedColor(
                    R.attr.brand_bg_primary,
                    viewBinding.actionButton.context
                )
            )
        )

    }
    // endregion

}
