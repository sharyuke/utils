package com.sharyuke.app

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class NetworkActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_network)
        title = "网络"
    }
}