package com.sharyuke.app.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.sharyuke.app.R
import com.sharyuke.utils.adapterCreate
import com.sharyuke.utils.withRecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val list = listOf(
            HomeItem(R.mipmap.home_view, "视图") { startActivity(Intent(this, ViewActivity::class.java)) },
            HomeItem(R.mipmap.home_file, "文件") { startActivity(Intent(this, FileActivity::class.java)) },
            HomeItem(R.mipmap.home_net, "网络") { startActivity(Intent(this, NetworkActivity::class.java)) },
            HomeItem(R.mipmap.home_device, "硬件") { startActivity(Intent(this, DeviceActivity::class.java)) },
            HomeItem(R.mipmap.home_other, "其他") { startActivity(Intent(this, OtherActivity::class.java)) },
            HomeItem(R.mipmap.home_tool, "工具") { startActivity(Intent(this, ToolsActivity::class.java)) },
        )
        adapterCreate(R.layout.item_home, list) {
            onHasItem {
                setImageResource(R.id.item_home_img, icon)
                setText(R.id.item_home_name, name)
            }
            onItemClick { item.onClick() }
        }.withRecyclerView(findViewById(R.id.home_recycler_view))
    }
}

data class HomeItem(val icon: Int, val name: String, val onClick: () -> Unit)

