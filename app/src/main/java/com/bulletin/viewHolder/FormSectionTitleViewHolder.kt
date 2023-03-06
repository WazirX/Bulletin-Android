//package com.app.BitRabbit.Classes.Components.FormCollection.Views
//
//import android.view.View
//import com.bulletin.models.Title
//
//
//class FormSectionTitleViewHolder(val viewBinding : LayoutFormSectionAppInfoBinding, listener : FormRecyclerViewAdapter.OnItemClickListener) :
//    BaseViewHolder<Title>(viewBinding,listener) {
//
//    // region Methods
//     override fun bind(item: Title) {
//        super.bind(item)
//
//        itemView.setOnClickListener {
//
//        }
//
//        // Set App Title
//        if (!item.appName.isNullOrBlank()) {
//            viewBinding.appNameLabel.text = item.appName
//            viewBinding.appNameLabel.setVisibility(View.VISIBLE)
//        } else {
//            viewBinding.appNameLabel.text = ""
//            viewBinding.appNameLabel.setVisibility(View.GONE)
//        }
//
//        // Set App Version
//        if (!item.appVersion.isNullOrBlank()) {
//            viewBinding.appVersionLabel.text = item.appVersion
//            viewBinding.appVersionLabel.setVisibility(View.VISIBLE)
//        } else {
//            viewBinding.appVersionLabel.text = ""
//            viewBinding.appVersionLabel.setVisibility(View.GONE)
//        }
//
//    }
//
//    override fun getBackgroundView(): View? {
//        return null
//    }
//
//    override fun updateAppearance() {
//        super.updateAppearance()
//
//        // Set Default Properties
//        viewBinding.appNameLabel.typeface = AppStyle.Font.Bold()
//        viewBinding.appNameLabel.setTextColor(ThemeUtils.getAttributedColor(R.attr.text_2, viewBinding.appNameLabel.context))
//
//        viewBinding.appVersionLabel.typeface = AppStyle.Font.DemiBold()
//        viewBinding.appVersionLabel.setTextColor(ThemeUtils.getAttributedColor(R.attr.text_2, viewBinding.appVersionLabel.context))
//
//    }
//    // endregion
//
//}
