package com.sharyuke.app

import android.os.Bundle
import android.view.View
import android.view.ViewStub
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.utils.widget.ImageFilterView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.slider.Slider
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
            ImageModel("圆角", R.layout.item_image_1, R.id.item_image_1),
            ImageModel("对比度", R.layout.item_image_2, R.id.item_image_2),
            ImageModel("亮度", R.layout.item_image_3, R.id.item_image_3),
            ImageModel("饱和度", R.layout.item_image_4, R.id.item_image_4),
        )
        findViewById<RecyclerView>(R.id.view_pic_rv).adapter = adapterCreate(R.layout.item_pic, list) {
            onHasItem {
                val imageView = getView<ViewStub>(R.id.item_view_sub).inflateAndFindView<ImageFilterView>(layout, id)
                imageView.loadUrl(DEMO_IMAGE_URL)
                val slider = getView<Slider>(R.id.item_slider)
                slider.valueFrom = 0f
                slider.visibility = View.VISIBLE
                setText(R.id.item_name, String.format("%s：%.2f", name,
                    when (adapterPosition) {
                        0 -> 0f.apply { slider.visibility = View.GONE }
                        1 -> slider.apply { valueTo = 1f }.let { 1f }
                        2 -> slider.apply { valueTo = 4f }.let { 0.5f }
                        3 -> slider.apply { valueTo = 3f }.let { 0.5f }
                        4 -> slider.apply { valueTo = 4f }.let { 0.5f }
                        else -> 0f
                    }.apply { slider.value = this })
                )
                slider.addOnChangeListener { _, value, _ ->
                    when (adapterPosition) {
                        1 -> imageView.roundPercent = value
                        2 -> imageView.contrast = value
                        3 -> imageView.brightness = value
                        4 -> imageView.saturation = value
                    }
                    setText(R.id.item_name, String.format("%s：%.2f", name, value))
                }
            }
        }
    }
}

private fun <T> ViewStub.inflateAndFindView(layout: Int, id: Int): T = apply { layoutResource = layout }.inflate().findViewById(id)

data class ImageModel(val name: String, val layout: Int, val id: Int)