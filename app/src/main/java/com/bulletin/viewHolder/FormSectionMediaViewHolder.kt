package com.bulletin.viewHolder

import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import android.view.View
import com.bulletin.FormRecyclerViewAdapter
import com.bulletin.extension.loadImageWithUrl
import com.bumptech.glide.request.target.CustomTarget
import com.bumptech.glide.request.transition.Transition
import com.example.bulletin.databinding.LayoutFormSectionMediaBinding
import com.wrx.wazirx.views.bulletin.model.Media


class FormSectionMediaViewHolder(val viewBinding : LayoutFormSectionMediaBinding, listener : FormRecyclerViewAdapter.OnItemClickListener) :
    BaseViewHolder<Media>(viewBinding,listener) {

    // region Methods
     override fun bind(item: Media) {
        super.bind(item)

        // Set Image
        viewBinding.bannerImageView.setVisibility(View.GONE)
        if(!item.url.isNullOrBlank()) {

            viewBinding.bannerImageView.loadImageWithUrl(
                viewBinding.bannerImageView.getContext(),
                item.url,
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

                    override fun onLoadCleared(placeholder: Drawable?) {}
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
