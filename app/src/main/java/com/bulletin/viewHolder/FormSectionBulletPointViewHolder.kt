package com.bulletin.viewHolder

import android.os.Build
import android.view.View
import com.bulletin.FormRecyclerViewAdapter
import com.bulletin.models.BulletPoint
import com.bulletin.utilities.ThemeUtils
import com.example.bulletin.R
import com.example.bulletin.databinding.LayoutFormBulletPointBinding


class FormSectionBulletPointViewHolder(val viewBinding : LayoutFormBulletPointBinding, listener : FormRecyclerViewAdapter.OnItemClickListener) :
    BaseViewHolder<BulletPoint>(viewBinding,listener) {

    // region Methods
     override fun bind(item: BulletPoint) {
        super.bind(item)

        // Set Pre Title
        if (!item.titleText.isNullOrBlank()) {
            viewBinding.titleLabel.text = item.titleText
            viewBinding.titleLabel.setVisibility(View.VISIBLE)
        } else {
            viewBinding.titleLabel.text = ""
            viewBinding.titleLabel.setVisibility(View.GONE)
        }

        // Set Title
        if (!item.subTitleText.isNullOrBlank()) {
            viewBinding.subtitleLabel.text = item.subTitleText
            viewBinding.subtitleLabel.setVisibility(View.VISIBLE)
        } else {
            viewBinding.subtitleLabel.text = ""
            viewBinding.subtitleLabel.setVisibility(View.GONE)
        }

    }

    override fun updateAppearance() {
        super.updateAppearance()

        // Set Default Properties
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            viewBinding.titleLabel.setTextAppearance(R.style.large_semi_bold)
            viewBinding.subtitleLabel.setTextAppearance(R.style.base_regular)
        } else {
            viewBinding.titleLabel.setTextAppearance(viewBinding.titleLabel.context, R.style.large_semi_bold)
            viewBinding.subtitleLabel.setTextAppearance(viewBinding.subtitleLabel.context, R.style.base_regular)
        }

        viewBinding.titleLabel.setTextColor(ThemeUtils.getAttributedColor(R.attr.main_text_primary, viewBinding.titleLabel.context))
        viewBinding.subtitleLabel.setTextColor(ThemeUtils.getAttributedColor(R.attr.main_text_secondary, viewBinding.subtitleLabel.context))

    }

    override fun getBackgroundView(): View? {
        return null
    }
    // endregion

}
