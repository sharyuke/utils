package com.sharyuke.app

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.sharyuke.utils.adapterCreate

class ViewListLayoutManagerActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_list_layout_manager)
        title = "LayoutManager"
        val list = listOf(
            ItemSimple(R.mipmap.icon_list, "流式布局") { startActivity(Intent(this, ViewListLayoutManagerFlexActivity::class.java)) },
            ItemSimple(R.mipmap.icon_list, "网格布局") { startActivity(Intent(this, ViewListLayoutManagerGridActivity::class.java)) },
        )
        findViewById<RecyclerView>(R.id.view_list_layout_manager_rv).adapter = adapterCreate(R.layout.item_simple_txt, list) {
            onHasItem {
                setImageResource(R.id.item_simple_icon, icon)
                setText(R.id.item_simple_txt, name)
            }
            onItemClick { item.onClick() }
        }
    }
}
