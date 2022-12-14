package com.sharyuke.app.ui

import android.content.Intent
import android.os.Bundle
import android.view.ViewStub
import androidx.appcompat.app.AppCompatActivity
import com.sharyuke.app.R
import com.sharyuke.utils.adapterCreate
import com.sharyuke.utils.withRecyclerView

class ViewImageActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_image)
        title = "图片工具"
        val list = listOf(
            ViewImageModel(R.mipmap.icon_list, "ImageFilterView") { startActivity(Intent(this, ViewImageFilterActivity::class.java)) },
            ViewImageModel(R.mipmap.icon_list, "ImageShapeableView") { startActivity(Intent(this, ViewImageShapeableActivity::class.java)) }
        )
        adapterCreate(R.layout.item_view_image, list) {
            onHasItem {
                setImageResource(R.id.item_view_image_icon, icon)
                setText(R.id.item_view_image_name, name)
            }
            onItemClick { item.onClick() }
        }.withRecyclerView(findViewById(R.id.view_image_rv))
    }
}

data class ViewImageModel(val icon: Int, val name: String, val onClick: () -> Unit)

fun <T> ViewStub.inflateAndFindView(layout: Int, id: Int): T = apply { layoutResource = layout }.inflate().findViewById(id)
