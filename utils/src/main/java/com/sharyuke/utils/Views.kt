package com.sharyuke.utils

import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.ImageView

var lastClickTime = 0L//防止两次点击过快

val uiHandler = Handler(Looper.getMainLooper())

fun <T : View> T.onClick(back: T.() -> Unit): T {
    setOnClickListener {
        val time = System.currentTimeMillis()
        if (time - lastClickTime > 500) { // 多种方式防止双重点击
            back(this)
            uiHandler.postDelayed({ isClickable = true }, 500)
            isClickable = false
            lastClickTime = time
        }
    }
    return this
}

fun ImageView.loadUrl(url: String?) {
    url?.let {
        // TODO Use your Image load Framework
    }
}