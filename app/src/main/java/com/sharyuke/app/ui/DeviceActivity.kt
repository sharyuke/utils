package com.sharyuke.app.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.sharyuke.app.R

class DeviceActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_device)
        title = "硬件"
    }
}