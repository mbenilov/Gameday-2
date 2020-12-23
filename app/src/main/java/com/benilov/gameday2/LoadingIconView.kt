package com.benilov.gameday2

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.view.animation.Animation
import android.view.animation.RotateAnimation
import android.widget.FrameLayout
import android.widget.ImageView

class LoadingIconView(
    context: Context,
    attrs: AttributeSet
): FrameLayout(context, attrs) {

    private lateinit var icon: ImageView

    private var anim: RotateAnimation = RotateAnimation(0f, 360f,
        Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f)

    init {
        if (!isInEditMode) {
            initialize()
        }
    }

    private fun initialize() {
        View.inflate(context, R.layout.view_loading_icon, this)
        icon = findViewById(R.id.icon)
        anim.duration = 1000
        anim.repeatCount = Animation.INFINITE
    }

    fun start() {
        this.visibility = VISIBLE
        icon.startAnimation(anim)
    }

    fun stop() {
        this.visibility = GONE
        icon.clearAnimation()
    }
}