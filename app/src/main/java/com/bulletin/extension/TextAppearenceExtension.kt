package com.bulletin.extension

import android.os.Build
import android.widget.TextView
import androidx.annotation.StyleRes


fun TextView.textAppearence(@StyleRes resId : Int) {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
        this.setTextAppearance(resId)
    } else {
        this.setTextAppearance(this.context, resId)
    }
}

