package com.bulletin.utilities

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Color
import android.view.Gravity
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.DecelerateInterpolator
import android.view.animation.ScaleAnimation
import android.widget.TextView


object ViewUtil {

    @SuppressLint("ClickableViewAccessibility")
    fun addBounceEffect(view: View) {
        view.setOnTouchListener { v: View, event: MotionEvent ->
            onButtonTouch(
                v,
                event
            )
        }
    }

    private fun onButtonTouch(button: View, event: MotionEvent): Boolean {
        if (event.action == MotionEvent.ACTION_DOWN) {
            onButtonPressed(button)
            return true
        } else if (event.action == MotionEvent.ACTION_UP || event.action == MotionEvent.ACTION_CANCEL || event.action == MotionEvent.ACTION_OUTSIDE) {
            onButtonReleased(button)
        }

        // Handle click event
        if (event.action == MotionEvent.ACTION_UP) {
            button.performClick()
        }
        return false
    }

    private fun onButtonTouchListener(
        button: View,
        event: MotionEvent,
        touchListener: TouchListener
    ): Boolean {
        if (event.action == MotionEvent.ACTION_DOWN) {
            // onButtonPressed(button);
            touchListener.onButtonPressed()
            return true
        } else if (event.action == MotionEvent.ACTION_UP || event.action == MotionEvent.ACTION_CANCEL || event.action == MotionEvent.ACTION_OUTSIDE) {
            //  onButtonReleased(button);
            touchListener.onButtonReleased()
        }

        // Handle click event
        if (event.action == MotionEvent.ACTION_UP) {
            button.performClick()
        }
        return false
    }

    fun onButtonPressed(button: View) {
        val scaleAnimation = ScaleAnimation(
            1f, 0.9f,
            1f, 0.9f,
            Animation.RELATIVE_TO_SELF, 0.5f,
            Animation.RELATIVE_TO_SELF, 0.5f
        )
        scaleAnimation.interpolator = DecelerateInterpolator()
        scaleAnimation.duration = 100
        scaleAnimation.fillAfter = true
        button.startAnimation(scaleAnimation)
    }

    fun onButtonReleased(button: View) {
        val scaleAnimation = ScaleAnimation(
            0.9f, 1f,
            0.9f, 1f,
            Animation.RELATIVE_TO_SELF, 0.5f,
            Animation.RELATIVE_TO_SELF, 0.5f
        )
        scaleAnimation.interpolator = DecelerateInterpolator()
        scaleAnimation.duration = 100
        scaleAnimation.fillAfter = true
        button.startAnimation(scaleAnimation)
    }

    interface TouchListener {
        fun onButtonPressed()
        fun onButtonReleased()
    }
}