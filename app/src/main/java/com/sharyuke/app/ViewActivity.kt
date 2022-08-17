package com.sharyuke.app

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.sharyuke.utils.adapterCreate
import com.sharyuke.utils.withRecyclerView

class ViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view)
        title = "视图"
        val list = listOf(
            ViewItem(R.mipmap.icon_list, "列表") { startActivity(Intent(this, ViewListActivity::class.java)) },
            ViewItem(R.mipmap.icon_pic, "图片") { startActivity(Intent(this, ViewImageActivity::class.java)) },
        )
        adapterCreate(R.layout.item_home, list) {
            onHasItem {
                setImageResource(R.id.item_home_img, icon)
                setText(R.id.item_home_name, name)
            }
            onItemClick { item.onClick() }
        }.withRecyclerView(findViewById(R.id.view_recycler_view))
    }
}

data class ViewItem(val icon: Int, val name: String, val onClick: () -> Unit)
