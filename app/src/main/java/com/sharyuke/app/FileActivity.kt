package com.sharyuke.app

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class FileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_file)
        title = "文件"
    }
}