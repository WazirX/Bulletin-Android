package com.bulletin.viewHolder

import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import android.os.Build
import android.view.View
import androidx.core.text.HtmlCompat
import com.bulletin.FormRecyclerViewAdapter
import com.bulletin.extension.loadImageWithUrl
import com.bulletin.models.Bullet
import com.bulletin.models.BulletPoint
import com.bulletin.models.Message
import com.bulletin.utilities.ThemeUtils
import com.bumptech.glide.request.target.CustomTarget
import com.bumptech.glide.request.transition.Transition
import com.example.bulletin.R
import com.example.bulletin.databinding.LayoutFormBulletPointBinding


class FormSectionBulletPointViewHolder(
    val viewBinding: LayoutFormBulletPointBinding,
    listener: FormRecyclerViewAdapter.OnItemClickListener
) :
    BaseViewHolder<BulletPoint>(viewBinding, listener) {

    // region Methods
    override fun bind(item: BulletPoint) {
        super.bind(item)

        viewBinding.bulletImageView.setVisibility(View.GONE)
        viewBinding.bulletLabel.setVisibility(View.GONE)

        when (item.bullet?.bulletType) {
            Bullet.BulletType.UNICODE -> {

                val unicode = item.bullet?.unicode
                if (!unicode.isNullOrBlank()) {
                    val fromHtml = HtmlCompat.fromHtml(unicode, HtmlCompat.FROM_HTML_MODE_COMPACT)
                    viewBinding.bulletLabel.text = fromHtml
                    viewBinding.bulletLabel.setVisibility(View.VISIBLE)
                } else {
                    viewBinding.bulletLabel.text = ""
                    viewBinding.bulletLabel.setVisibility(View.GONE)
                }

            }
            Bullet.BulletType.IMAGE -> {
                (item.bullet?.imageUrl)?.let {

                    viewBinding.bulletImageView.loadImageWithUrl(
                        viewBinding.bulletImageView.getContext(),
                        it,
                        null,
                        object : CustomTarget<Drawable?>() {

                            override fun onResourceReady(
                                resource: Drawable,
                                transition: Transition<in Drawable?>?
                            ) {
                                val bitmap = (resource as BitmapDrawable).bitmap
                                viewBinding.bulletImageView.setImageBitmap(bitmap)
                                viewBinding.bulletLabel.setVisibility(View.GONE)
                                viewBinding.bulletImageView.setVisibility(View.VISIBLE)
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
            else -> {

            }
        }

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
            viewBinding.titleLabel.setTextAppearance(
                viewBinding.titleLabel.context,
                R.style.large_semi_bold
            )
            viewBinding.subtitleLabel.setTextAppearance(
                viewBinding.subtitleLabel.context,
                R.style.base_regular
            )
        }

        viewBinding.titleLabel.setTextColor(
            ThemeUtils.getAttributedColor(
                R.attr.main_text_primary,
                viewBinding.titleLabel.context
            )
        )
        viewBinding.subtitleLabel.setTextColor(
            ThemeUtils.getAttributedColor(
                R.attr.main_text_secondary,
                viewBinding.subtitleLabel.context
            )
        )

    }

    override fun getBackgroundView(): View? {
        return null
    }
    // endregion

}
