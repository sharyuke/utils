package com.sharyuke.app

import android.os.Bundle
import android.view.ViewStub
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.utils.widget.ImageFilterView
import androidx.recyclerview.widget.RecyclerView
import com.sharyuke.utils.adapterCreate
import com.sharyuke.utils.loadUrl

const val DEMO_IMAGE_URL = "https://pic.qqtn.com/up/2017-11/15102069107000700.jpg"

class ViewImageActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_image)
        title = "图片"
        val list = listOf(
            ImageModel("原图", R.layout.item_image_0, R.id.item_image_0),
            ImageModel("全圆角", R.layout.item_image_1, R.id.item_image_1),
            ImageModel("对比度", R.layout.item_image_2, R.id.item_image_2),
            ImageModel("亮度", R.layout.item_image_3, R.id.item_image_3),
        )
        findViewById<RecyclerView>(R.id.view_pic_rv).adapter = adapterCreate(R.layout.item_pic, list) {
            onHasItem {
                getView<ViewStub>(R.id.item_view_sub).inflateAndFindView<ImageFilterView>(layout, id).loadUrl(DEMO_IMAGE_URL)
                setText(R.id.item_name, name)
            }
        }
    }
}

private fun <T> ViewStub.inflateAndFindView(layout: Int, id: Int): T = apply { layoutResource = layout }.inflate().findViewById(id)

data class ImageModel(val name: String, val layout: Int, val id: Int)