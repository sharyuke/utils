package com.sharyuke.utils

import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.ImageView
import com.bumptech.glide.Glide

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

fun <T : View> T.onLongClick(back: T.() -> Unit): T {
    setOnLongClickListener {
        val time = System.currentTimeMillis()
//        if (time - lastClickTime > 500) { // 多种方式防止双重点击
        back(this)// 长按大概率不会重复点击，所以去掉重复点击逻辑
//            uiHandler.postDelayed({ isClickable = true }, 500)
//            isClickable = false
//            lastClickTime = time
//        }
        false
    }
    return this
}

fun ImageView.loadUrl(url: String?) {
    url?.let { Glide.with(context).load(it).into(this) }
}