package com.sharyuke.app

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.sharyuke.utils.adapterCreate

const val TITLE = "title"

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val list = listOf(
            HomeItem(R.mipmap.home_view, "视图"),
            HomeItem(R.mipmap.home_file, "文件"),
            HomeItem(R.mipmap.home_net, "网络"),
            HomeItem(R.mipmap.home_device, "硬件"),
            HomeItem(R.mipmap.home_view, "视图"),
        )
        findViewById<RecyclerView>(R.id.home_recycler_view).adapter = adapterCreate(R.layout.item_home, list) {
            onHasItem {
                setImageResource(R.id.item_home_img, icon)
                setText(R.id.item_home_name, name)
            }
            onItemClick {
                when (position) {
                    0 -> startActivity(Intent(this@MainActivity, ViewActivity::class.java).putExtra(TITLE, item.name))
                }
            }
        }
    }
}

data class HomeItem(val icon: Int, val name: String)

