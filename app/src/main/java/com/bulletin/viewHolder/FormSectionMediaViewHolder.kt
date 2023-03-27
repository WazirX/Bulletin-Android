package com.bulletin.viewHolder

import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import android.view.View
import com.bulletin.FormRecyclerViewAdapter
import com.bulletin.extension.loadImageWithUrl
import com.bulletin.utilities.DeviceUtil
import com.bumptech.glide.request.target.CustomTarget
import com.bumptech.glide.request.transition.Transition
import com.example.bulletin.databinding.LayoutFormSectionMediaBinding
import com.wrx.wazirx.views.bulletin.model.Media


class FormSectionMediaViewHolder(
    val viewBinding: LayoutFormSectionMediaBinding,
    listener: FormRecyclerViewAdapter.OnItemClickListener
) :
    BaseViewHolder<Media>(viewBinding, listener) {

    // region Methods
    override fun bind(item: Media) {
        super.bind(item)

        // Set Image
        viewBinding.bannerImageView.setVisibility(View.GONE)

        item.size?.let {
             viewBinding.bannerImageView.layoutParams.width = DeviceUtil.convertPixelsToDp(viewBinding.bannerImageView.context,it.width.toFloat()).toInt()
             viewBinding.bannerImageView.layoutParams.height = DeviceUtil.convertPixelsToDp(viewBinding.bannerImageView.context,it.height.toFloat()).toInt()
        }

        (item.url)?.let {

            viewBinding.bannerImageView.loadImageWithUrl(
                viewBinding.bannerImageView.getContext(),
                it,
                null,
                object : CustomTarget<Drawable?>() {

                    override fun onResourceReady(
                        resource: Drawable,
                        transition: Transition<in Drawable?>?
                    ) {
                        val bitmap = (resource as BitmapDrawable).bitmap
                        viewBinding.bannerImageView.setImageBitmap(bitmap)
                        viewBinding.bannerImageView.setVisibility(View.VISIBLE)
                    }

                    override fun onLoadFailed(errorDrawable: Drawable?) {
                        print("onLoadFailed")
                    }

                    override fun onLoadCleared(placeholder: Drawable?) {
                        print("onLoadCleared")
                    }

                })
        }

    }

    override fun getBackgroundView(): View? {
        return null
    }

    override fun updateAppearance() {
        super.updateAppearance()
    }
    // endregion

}
