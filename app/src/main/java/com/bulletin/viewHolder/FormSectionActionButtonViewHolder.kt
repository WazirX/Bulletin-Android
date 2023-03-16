package com.bulletin.viewHolder

import android.os.Build
import android.view.View
import com.bulletin.FormRecyclerViewAdapter
import com.bulletin.models.ActionButton
import com.bulletin.utilities.DeviceUtil
import com.bulletin.utilities.ThemeUtils
import com.example.bulletin.R
import com.example.bulletin.databinding.LayoutFormSectionActionButtonBinding


class FormSectionActionButtonViewHolder(val viewBinding : LayoutFormSectionActionButtonBinding, listener : FormRecyclerViewAdapter.OnItemClickListener) :
    BaseViewHolder<ActionButton>(viewBinding,listener) {

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

    }

    override fun getBackgroundView(): View? {
        return null
    }

    override fun updateAppearance() {
        super.updateAppearance()

        // Set Default Properties
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            viewBinding.actionButton.setTextAppearance(R.style.base_semi_bold)
        } else {
            viewBinding.actionButton.setTextAppearance(viewBinding.actionButton.context, R.style.large_bold)
        }
        viewBinding.actionButton.setTextColor(ThemeUtils.getAttributedColor(R.attr.brand_text_primary, viewBinding.actionButton.context))
        viewBinding.actionButton.setBackgroundColor(ThemeUtils.getAttributedColor(R.attr.main_bg_surface_alt, viewBinding.actionButton.context))
        ThemeUtils.applyThemeBorder(viewBinding.actionButton,R.attr.main_bg_surface_alt,
            DeviceUtil.convertDpToPixel(viewBinding.actionButton.context, 1f))

    }
    // endregion

}
