package com.sharyuke.app.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.sharyuke.app.ItemSimple
import com.sharyuke.app.R
import com.sharyuke.utils.adapterCreate
import com.sharyuke.utils.withRecyclerView

class ToolsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tools)
        title = "工具"
        val list = listOf(
            ItemSimple(R.mipmap.icon_list, "正则表达式") { startActivity(Intent(this, ToolsRegexActivity::class.java)) },
            ItemSimple(R.mipmap.icon_pic, "--") {},
        )
        adapterCreate(R.layout.item_simple_txt, list) {
            onHasItem {
                setImageResource(R.id.item_simple_icon, icon)
                setText(R.id.item_simple_name, name)
            }
            onItemClick { item.onClick() }
        }.withRecyclerView(findViewById(R.id.tools_home_rv))
    }
}