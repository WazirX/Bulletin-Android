package com.bulletin.utilities

import android.content.Context
import android.graphics.drawable.GradientDrawable
import android.util.TypedValue
import android.view.View
import androidx.annotation.AttrRes
import androidx.annotation.ColorInt


object ThemeUtils {
    @ColorInt
    fun getAttributedColor(@AttrRes attr: Int, context: Context): Int {
        val value = TypedValue()
        context.theme.resolveAttribute(attr, value, true)
        return value.data
    }

    fun applyThemeDrawable(view: View, @AttrRes attr: Int) {
        val color = getAttributedColor(attr, view.context)
        if (color != 0) {
            val drawable = view.background
            if (drawable is GradientDrawable) {
                drawable.setColor(color)
            }
            view.setBackgroundDrawable(drawable)
        }
    }
}
