package com.bulletin.utilities

import android.content.Context
import android.content.res.ColorStateList
import android.graphics.Color
import android.graphics.drawable.Drawable
import android.graphics.drawable.GradientDrawable
import android.graphics.drawable.StateListDrawable
import android.util.TypedValue
import android.view.View
import androidx.annotation.AttrRes
import androidx.annotation.ColorInt
import androidx.core.graphics.drawable.DrawableCompat


object ThemeUtils {
    @ColorInt
    fun getAttributedColor(@AttrRes attr: Int, context: Context): Int {
//        val a = context.theme.obtainStyledAttributes( Appearance.valueOf(Appearance.Current.value).ordinal, intArrayOf(attr))
//        return a.getColor(0, 0)
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

    fun applyThemeBorder(
        view: View,
        @AttrRes borderColor: Int,
        borderWidth: Int
    ): GradientDrawable? {
        val drawable = view.background as? GradientDrawable
        val color = getAttributedColor(borderColor, view.context)
        if (color != 0) {
            drawable?.setStroke(borderWidth, color)
        }
        return drawable
    }

    fun applyThemeDrawable(drawable: Drawable, context: Context, @AttrRes attr: Int): Drawable {
        val color = getAttributedColor(attr, context)
        if (color != 0) {
            if (drawable is GradientDrawable) {
                drawable.setColor(color)
            }
        }
        return drawable
    }

}
