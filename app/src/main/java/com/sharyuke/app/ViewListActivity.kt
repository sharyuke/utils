package com.sharyuke.app

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.sharyuke.utils.adapterCreate
import com.sharyuke.utils.withRecyclerView

class ViewListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_list)
        title = "列表"
        val list = listOf(
            ItemSimple(R.mipmap.icon_list_page, "布局管理") { startActivity(Intent(this, ViewListLayoutManagerActivity::class.java)) },
            ItemSimple(R.mipmap.icon_list, "简单列表") { startActivity(Intent(this, ViewListBaseActivity::class.java)) },
            ItemSimple(R.mipmap.icon_list_group, "分组列表") { Toast.makeText(this, "还没做", Toast.LENGTH_LONG).show() },
            ItemSimple(R.mipmap.icon_list_page, "分页列表") { Toast.makeText(this, "还没做", Toast.LENGTH_LONG).show() },
        )
        adapterCreate(R.layout.item_simple_txt, list) {
            onHasItem {
                setImageResource(R.id.item_simple_icon, icon)
                setText(R.id.item_simple_txt, name)
            }
            onItemClick { item.onClick() }
        }.withRecyclerView(findViewById(R.id.view_list_rv))
    }
}