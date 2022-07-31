package com.sharyuke.app

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class ViewListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_list)
        title = "列表"
    }
}