//package com.app.BitRabbit.Classes.Components.FormCollection.Views
//
//import android.graphics.drawable.BitmapDrawable
//import android.graphics.drawable.Drawable
//import android.view.View
//import com.app.BitRabbit.Classes.Components.FormCollection.FormRecyclerViewAdapter
//import com.app.BitRabbit.Classes.Components.FormCollection.Model.SectionItems.FormSectionBigTitleItem
//import com.app.BitRabbit.Classes.Constants.AppStyle
//import com.app.BitRabbit.Core.Extensions.ThemeUtils
//import com.app.BitRabbit.Core.Extensions.loadImageWithUrl
//import com.app.BitRabbit.R
//import com.app.BitRabbit.databinding.LayoutFormSectionBigTitleItemBinding
//import com.bulletin.models.BulletPoint
//import com.bumptech.glide.request.target.CustomTarget
//import com.bumptech.glide.request.transition.Transition
//
//
//class FormSectionBulletPointViewHolder(val viewBinding : LayoutFormSectionBigTitleItemBinding, listener : FormRecyclerViewAdapter.OnItemClickListener) :
//    BaseViewHolder<FormSectionBigTitleItem>(viewBinding,listener) {
//
//    // region Methods
//     override fun bind(item: BulletPoint) {
//        super.bind(item)
//
//        // Set Pre Title
//        if (!item.pretitle.isNullOrBlank()) {
//            viewBinding.pretitleLabel.text = item.pretitle
//            viewBinding.pretitleLabel.setVisibility(View.VISIBLE)
//        } else {
//            viewBinding.pretitleLabel.text = ""
//            viewBinding.pretitleLabel.setVisibility(View.GONE)
//        }
//
//        // Set Title
//        if (!item.title.isNullOrBlank()) {
//            viewBinding.titleLabel.text = item.title
//            viewBinding.titleLabel.setVisibility(View.VISIBLE)
//        } else {
//            viewBinding.titleLabel.text = ""
//            viewBinding.titleLabel.setVisibility(View.GONE)
//        }
//
//        // Set Icon Background Color
//        item.iconBackgroundColor?.also {
//            viewBinding.iconContainerView.setBackgroundColor(it)
//            viewBinding.iconContainerView.setVisibility(View.VISIBLE)
//        } ?: run {
//            viewBinding.iconContainerView.setVisibility(View.GONE)
//        }
//
//
//        // Set Image
//        viewBinding.iconImageView.setVisibility(View.GONE)
//        if(!item.iconImageUrl.isNullOrBlank()) {
//
//            viewBinding.iconImageView.loadImageWithUrl(
//                viewBinding.iconImageView.getContext(),
//                item.iconImageUrl!!,
//                null,
//                object : CustomTarget<Drawable?>() {
//
//                    override fun onResourceReady(
//                        resource: Drawable,
//                        transition: Transition<in Drawable?>?
//                    ) {
//                        val bitmap = (resource as BitmapDrawable).bitmap
//                        viewBinding.iconImageView.setImageBitmap(bitmap)
//                        viewBinding.iconImageView.setVisibility(View.VISIBLE)
//                    }
//
//                    override fun onLoadCleared(placeholder: Drawable?) {}
//                })
//        }
//
//        itemView.setOnClickListener {
//
//        }
//    }
//
//    override fun updateAppearance() {
//        super.updateAppearance()
//
//        // Set Default Properties
//        viewBinding.pretitleLabel.typeface = AppStyle.Font.Medium()
//        viewBinding.pretitleLabel.setTextColor(ThemeUtils.getAttributedColor(R.attr.text_2, viewBinding.titleLabel.context))
//
//        viewBinding.titleLabel.typeface = AppStyle.Font.Bold()
//        viewBinding.titleLabel.setTextColor(ThemeUtils.getAttributedColor(R.attr.text_1, viewBinding.pretitleLabel.context))
//
//        viewBinding.iconContainerView.setBackgroundColor(ThemeUtils.getAttributedColor(R.attr.text_2, viewBinding.iconContainerView.context))
//
//    }
//
//    override fun getBackgroundView(): View? {
//        return null
//    }
//    // endregion
//
//}
