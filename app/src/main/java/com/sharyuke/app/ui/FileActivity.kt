package com.sharyuke.app.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.sharyuke.app.ItemSimple
import com.sharyuke.app.R
import com.sharyuke.app.defaultList

class FileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_file)
        title = "文件"
        val list = listOf(
            ItemSimple(R.mipmap.icon_list, "数据库(Room)") { startActivity(Intent(this, FileRoomActivity::class.java)) },
            ItemSimple(R.mipmap.icon_pic, "--") {},
        )
        defaultList(list, findViewById(R.id.file_list_rv))
    }
}