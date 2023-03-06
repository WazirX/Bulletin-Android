//package com.app.BitRabbit.Classes.Components.FormCollection.Views
//
//import android.graphics.Color
//import android.view.View
//import com.wrx.wazirx.views.bulletin.model.Media
//
//
//class FormSectionMediaViewHolder(val viewBinding : LayoutFormSectionHeaderItemBinding, listener : FormRecyclerViewAdapter.OnItemClickListener) :
//    BaseViewHolder<Media>(viewBinding,listener) {
//
//    // region Methods
//     override fun bind(item: Media) {
//        super.bind(item)
//
//        // Set Title
//        if (!item.title.isNullOrBlank()) {
//            viewBinding.titleLabel.text = item.title
//            viewBinding.titleLabel.setVisibility(View.VISIBLE)
//
//            if (!item.titleColor.isNullOrBlank()) {
//                viewBinding.titleLabel.setTextColor(Color.parseColor(item.titleColor))
//            } else {
//                viewBinding.titleLabel.setTextColor(ThemeUtils.getAttributedColor(R.attr.text_1, viewBinding.titleLabel.getContext()))
//            }
//        } else {
//            viewBinding.titleLabel.text = ""
//            viewBinding.titleLabel.setVisibility(View.GONE)
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
//        viewBinding.titleLabel.typeface = AppStyle.Font.DemiBold()
//        viewBinding.titleLabel.setTextColor(ThemeUtils.getAttributedColor(R.attr.text_2, viewBinding.titleLabel.context))
//    }
//    // endregion
//
//}
