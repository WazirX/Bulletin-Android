//package com.app.BitRabbit.Classes.Components.FormCollection.Views
//
//import android.graphics.Color
//import android.graphics.PorterDuff
//import android.graphics.drawable.BitmapDrawable
//import android.graphics.drawable.Drawable
//import android.view.View
//import androidx.core.content.ContextCompat
//import com.bulletin.models.Message
//import com.bumptech.glide.request.target.CustomTarget
//import com.bumptech.glide.request.transition.Transition
//
//
//class FormSectionMessageViewHolder(val viewBinding : LayoutFormSectionDefaultItemBinding, listener : FormRecyclerViewAdapter.OnItemClickListener) :
//    BaseViewHolder<Message>(viewBinding,listener) {
//
//    // region Methods
//     override fun bind(item: Message) {
////        topCellSeparatorView = viewBinding.topCellSeparatorView
////        bottomCellSeparatorView = viewBinding.bottomCellSeparatorView
//
//        super.bind(item)
//
//        viewBinding.titleLabel.text = item.title
//
//        itemView.setOnClickListener {
//            _listener?.formDidTriggerEvent(item.eventType, item, bindingAdapterPosition)
//        }
//
//        // Set Image
//        viewBinding.iconImageView.setVisibility(View.GONE)
//        if(!item.iconUrl.isNullOrBlank()) {
//
//            val itemColor = if (!item.iconColor.isNullOrBlank()) Color.parseColor(item.iconColor)
//                            else ThemeUtils.getAttributedColor(R.attr.navigation_item, viewBinding.iconImageView.getContext())
//
//            viewBinding.iconImageView.loadImageWithUrl(
//                 viewBinding.iconImageView.getContext(),
//                 item.iconUrl!!,
//                 ColorFilterTransformation(viewBinding.iconImageView.getContext(), itemColor, true),
//                 object : CustomTarget<Drawable?>() {
//
//                     override fun onResourceReady(
//                         resource: Drawable,
//                         transition: Transition<in Drawable?>?
//                     ) {
//                         val bitmap = (resource as BitmapDrawable).bitmap
//                         viewBinding.iconImageView.setImageBitmap(bitmap)
//                         viewBinding.iconImageView.setVisibility(View.VISIBLE)
//                     }
//
//                     override fun onLoadCleared(placeholder: Drawable?) {}
//                 })
//        }
//
//        // Set Title
//        if (!item.title.isNullOrBlank()) {
//            viewBinding.titleLabel.text = item.title
//            viewBinding.titleLabel.setVisibility(View.VISIBLE)
//
//            if (!item.titleColor.isNullOrBlank()) {
//                viewBinding.titleLabel.setTextColor(Color.parseColor(item.titleColor))
//            } else {
//                viewBinding.titleLabel.setTextColor(ThemeUtils.getAttributedColor(R.attr.text_1, viewBinding.iconImageView.getContext()))
//            }
//        } else {
//            viewBinding.titleLabel.text = ""
//            viewBinding.titleLabel.setVisibility(View.GONE)
//        }
//
//        // Set Subttitle
//        if (!item.subtitle.isNullOrBlank()) {
//            viewBinding.subtitleLabel.text = item.subtitle
//            viewBinding.subtitleLabel.setVisibility(View.VISIBLE)
//
//            if (!item.subtitleColor.isNullOrBlank()) {
//                viewBinding.subtitleLabel.setTextColor(Color.parseColor(item.subtitleColor))
//            } else {
//                viewBinding.subtitleLabel.setTextColor(ThemeUtils.getAttributedColor(R.attr.text_1, viewBinding.iconImageView.getContext()))
//            }
//        } else {
//            viewBinding.subtitleLabel.text = ""
//            viewBinding.subtitleLabel.setVisibility(View.GONE)
//        }
//
//        // Set Value
//        if (!item.value.isNullOrBlank()) {
//            viewBinding.valueLabel.text = item.value
//            viewBinding.valueLabel.setVisibility(View.VISIBLE)
//
//            if (!item.valueColor.isNullOrBlank()) {
//                viewBinding.valueLabel.setTextColor(Color.parseColor(item.valueColor))
//            } else {
//                viewBinding.valueLabel.setTextColor(ThemeUtils.getAttributedColor(R.attr.text_1, viewBinding.iconImageView.getContext()))
//            }
//        } else {
//            viewBinding.valueLabel.text = ""
//            viewBinding.valueLabel.setVisibility(View.GONE)
//        }
//
//        // Set Accessory
//        when(item.accessoryType){
//            FormSectionDefaultItem.AccessoryType.SWITCH -> {
//                viewBinding.switchButton.setChecked(item.isSwitchAccessoryOn)
//                viewBinding.switchButton.setVisibility(View.VISIBLE)
//            }
//            FormSectionDefaultItem.AccessoryType.NONE -> {
//                viewBinding.switchButton.setVisibility(View.GONE)
//            }
//            else -> {
//                viewBinding.switchButton.setVisibility(View.GONE)
//            }
//        }
//
//        // Set Selection Accessory
//
//        when(item.selectionAccessoryType){
//            FormSectionDefaultItem.SelectionAccessoryType.DISCLOSURE_INDICATOR -> {
//                viewBinding.selectionAccessoryImageView.setImageDrawable(ContextCompat.getDrawable(viewBinding.selectionAccessoryImageView.context, R.drawable.ic_chevron_right));
//                viewBinding.selectionAccessoryImageView.setVisibility(View.VISIBLE)
//            }
//            FormSectionDefaultItem.SelectionAccessoryType.CHECKMARK -> {
//                viewBinding.selectionAccessoryImageView.setImageDrawable(ContextCompat.getDrawable(viewBinding.selectionAccessoryImageView.context, R.drawable.ic_checkmark));
//                viewBinding.selectionAccessoryImageView.setVisibility(View.VISIBLE)
//            }
//            else -> {
//                viewBinding.selectionAccessoryImageView.setVisibility(View.GONE)
//            }
//        }
//
//        viewBinding.switchButton.setOnCheckedChangeListener({ _ , isChecked ->
//             if (isChecked) {
//                 _listener?.formDidTriggerEvent(item.switchOnAccessoryEventType, item, adapterPosition)
//             } else {
//                 _listener?.formDidTriggerEvent(item.switchOffAccessoryEventType, item, adapterPosition)
//             }
//        })
//
//        when(item.selectionAccessoryType){
//
//            FormSectionDefaultItem.SelectionAccessoryType.DISCLOSURE_INDICATOR -> {
//                viewBinding.selectionAccessoryImageView.setVisibility(View.VISIBLE)
//                viewBinding.selectionAccessoryImageView.setImageDrawable(ContextCompat.getDrawable(viewBinding.selectionAccessoryImageView.context, R.drawable.ic_chevron_right));
//                viewBinding.selectionAccessoryImageView.setColorFilter(
//                    ThemeUtils.getAttributedColor(
//                        R.attr.text_2,
//                        viewBinding.selectionAccessoryImageView.context
//                    ), PorterDuff.Mode.SRC_IN
//                )
//            }
//            FormSectionDefaultItem.SelectionAccessoryType.CHECKMARK -> {
//                viewBinding.selectionAccessoryImageView.setVisibility(View.VISIBLE)
//                viewBinding.selectionAccessoryImageView.setColorFilter(
//                    ThemeUtils.getAttributedColor(
//                        R.attr.highlight_1,
//                        viewBinding.selectionAccessoryImageView.context
//                    ), PorterDuff.Mode.SRC_IN
//                )
//            }
//            else -> {
//                viewBinding.selectionAccessoryImageView.setVisibility(View.GONE)
//            }
//        }
//
//    }
//
//    override fun getCellFirstSeparatorView() : View {
//        return viewBinding.topCellSeparatorView
//    }
//
//    override fun getCellBottomSeparatorView() : View {
//        return viewBinding.bottomCellSeparatorView
//    }
//
//    override fun getBackgroundView(): View {
//        return viewBinding.itemBackground
//    }
//
//    override fun updateAppearance() {
//        super.updateAppearance()
//
//        // Set Default Properties
//        viewBinding.backgroundContainerView.setBackgroundColor(ThemeUtils.getAttributedColor(R.attr.background_1, viewBinding.backgroundContainerView.context))
//
//        viewBinding.titleLabel.typeface = AppStyle.Font.DemiBold()
//        viewBinding.titleLabel.setTextColor(ThemeUtils.getAttributedColor(R.attr.text_1, viewBinding.titleLabel.context))
//
//        viewBinding.subtitleLabel.typeface = AppStyle.Font.DemiBold()
//        viewBinding.subtitleLabel.setTextColor(ThemeUtils.getAttributedColor(R.attr.text_2, viewBinding.subtitleLabel.context))
//
//        viewBinding.valueLabel.typeface = AppStyle.Font.Medium()
//        viewBinding.valueLabel.setTextColor(ThemeUtils.getAttributedColor(R.attr.text_2, viewBinding.valueLabel.context))
//
//    }
//    // endregion
//
//}
