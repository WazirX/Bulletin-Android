package com.bulletin.extension

import android.content.Context
import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestBuilder
import com.bumptech.glide.load.Transformation
import com.bumptech.glide.request.target.CustomTarget
import com.example.bulletin.R


fun ImageView.loadImageWithUrl(
    context: Context,
    url: String,
    transform: Transformation<Bitmap?>?,
    completion: CustomTarget<Drawable?>
) {
    var builder: RequestBuilder<Drawable?> = Glide.with(context)
        .load(url)
        .error(R.drawable.image_loading_bg)
    if (transform != null) {
        builder = builder.transform(transform)
    }
    builder.into(completion)
}
