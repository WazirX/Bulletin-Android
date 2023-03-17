package com.bulletin.viewHolder

import android.os.Build
import android.view.View
import com.bulletin.FormRecyclerViewAdapter
import com.bulletin.models.Title
import com.bulletin.utilities.ThemeUtils
import com.example.bulletin.R
import com.example.bulletin.databinding.LayoutFormSectionTitleBinding


class FormSectionTitleViewHolder(val viewBinding : LayoutFormSectionTitleBinding, listener : FormRecyclerViewAdapter.OnItemClickListener) :
    BaseViewHolder<Title>(viewBinding,listener) {

    // region Methods
     override fun bind(item: Title) {
        super.bind(item)

        itemView.setOnClickListener {

        }

        // Set App Title
        if (!item.preTitleText.isNullOrBlank()) {
            viewBinding.preTitleLabel.text = item.preTitleText
            viewBinding.preTitleLabel.setVisibility(View.VISIBLE)
        } else {
            viewBinding.preTitleLabel.text = ""
            viewBinding.preTitleLabel.setVisibility(View.GONE)
        }

        // Set App Version
        if (!item.titleText.isNullOrBlank()) {
            viewBinding.titleLabel.text = item.titleText
            viewBinding.titleLabel.setVisibility(View.VISIBLE)
        } else {
            viewBinding.titleLabel.text = ""
            viewBinding.titleLabel.setVisibility(View.GONE)
        }

        // Set App Version
        if (!item.subTitleText.isNullOrBlank()) {
            viewBinding.subtitleLabel.text = item.subTitleText
            viewBinding.subtitleLabel.setVisibility(View.VISIBLE)
        } else {
            viewBinding.subtitleLabel.text = ""
            viewBinding.subtitleLabel.setVisibility(View.GONE)
        }

    }

    override fun getBackgroundView(): View? {
        return null
    }

    override fun updateAppearance() {
        super.updateAppearance()

        // Set Default Properties
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            viewBinding.preTitleLabel.setTextAppearance(R.style.small_medium)
            viewBinding.titleLabel.setTextAppearance(R.style.heading_4_semi_bold)
            viewBinding.subtitleLabel.setTextAppearance(R.style.base_regular)
        } else {
            viewBinding.preTitleLabel.setTextAppearance(viewBinding.preTitleLabel.context, R.style.small_medium)
            viewBinding.titleLabel.setTextAppearance(viewBinding.titleLabel.context, R.style.heading_4_semi_bold)
            viewBinding.subtitleLabel.setTextAppearance(viewBinding.subtitleLabel.context, R.style.base_regular)
        }

        viewBinding.preTitleLabel.setTextColor(ThemeUtils.getAttributedColor(R.attr.success_text_primary, viewBinding.preTitleLabel.context))
        viewBinding.titleLabel.setTextColor(ThemeUtils.getAttributedColor(R.attr.main_text_primary, viewBinding.titleLabel.context))
        viewBinding.subtitleLabel.setTextColor(ThemeUtils.getAttributedColor(R.attr.main_text_primary, viewBinding.subtitleLabel.context))

    }
    // endregion

}
