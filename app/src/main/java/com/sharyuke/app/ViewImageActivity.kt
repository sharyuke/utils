package com.sharyuke.app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.sharyuke.utils.loadUrl

class ViewImageActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_image)
        findViewById<ImageView>(R.id.view_image_demo).loadUrl("https://pic.qqtn.com/up/2017-11/15102069107000700.jpg")
    }
}