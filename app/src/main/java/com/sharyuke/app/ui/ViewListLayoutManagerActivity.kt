package com.sharyuke.app.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.sharyuke.app.ItemSimple
import com.sharyuke.app.R
import com.sharyuke.utils.adapterCreate
import com.sharyuke.utils.withRecyclerView

class ViewListLayoutManagerActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_list_layout_manager)
        title = "LayoutManager"
        val list = listOf(
            ItemSimple(R.mipmap.icon_list, "流式布局") { startActivity(Intent(this, ViewListLayoutManagerFlexActivity::class.java)) },
            ItemSimple(R.mipmap.icon_list, "网格布局") { startActivity(Intent(this, ViewListLayoutManagerGridActivity::class.java)) },
            ItemSimple(R.mipmap.icon_list, "瀑布布局") { startActivity(Intent(this, ViewListLayoutManagerStaggeredActivity::class.java)) },
        )
        adapterCreate(R.layout.item_simple_txt, list) {
            onHasItem {
                setImageResource(R.id.item_simple_icon, icon)
                setText(R.id.item_simple_name, name)
            }
            onItemClick { item.onClick() }
        }.withRecyclerView(findViewById(R.id.view_list_layout_manager_rv))
    }
}