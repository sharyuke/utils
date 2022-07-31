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

/**
 * 前面这4个属性 1.3.0 的 implementation("androidx.appcompat:appcompat:1.3.0") 包含
 * 后面的属性 需要1.4.1 才有
 * 功能：可以对图片进行简单的圆角，对比度、亮度、饱和度、缩放、旋转等操作。
 */
class ViewImageFilterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_image_filter)
        title = "ImageFilterView"
        val list = listOf(
            ImageFilterModel("原图", R.layout.item_image_0, R.id.item_image_0, 1f, 1f) { _, _ -> },
            ImageFilterModel("圆角", R.layout.item_image_1, R.id.item_image_1, 1f, 1f) { i, f -> i.roundPercent = f },
            ImageFilterModel("对比度", R.layout.item_image_2, R.id.item_image_2, 4f, .5f) { i, f -> i.contrast = f },
            ImageFilterModel("亮度", R.layout.item_image_3, R.id.item_image_3, 3f, .5f) { i, f -> i.brightness = f },
            ImageFilterModel("饱和度", R.layout.item_image_4, R.id.item_image_4, 4f, .5f) { i, f -> i.saturation = f },
            // 以下属性需要1.4.1+ 版本 1.3.0没有以下属性。
            ImageFilterModel("缩放", R.layout.item_image_5, R.id.item_image_5, 3f, 1f) { i, f -> i.imageZoom = f },
            ImageFilterModel("旋转", R.layout.item_image_6, R.id.item_image_6, 360f, 0f) { i, f -> i.imageRotate = f },
        )
        findViewById<RecyclerView>(R.id.view_image_filter_rv).adapter = adapterCreate(R.layout.item_view_image_filter, list) {
            onHasItem {
                val imageView = getView<ViewStub>(R.id.item_view_sub).inflateAndFindView<ImageFilterView>(layout, id)
                imageView.loadUrl(DEMO_IMAGE_URL)
                val slider = getView<Slider>(R.id.item_slider)
                slider.visibility = View.VISIBLE
                slider.valueTo = to
                slider.value = default
                setText(R.id.item_name, String.format("%s：%.2f", name, default))
                slider.addOnChangeListener { _, value, _ -> value.apply { onChange(imageView, value) }.apply { setText(R.id.item_name, String.format("%s：%.2f", name, this)) } }
                slider.visibility = if (adapterPosition == 0) View.GONE else View.VISIBLE
            }
        }
    }
}

data class ImageFilterModel(val name: String, val layout: Int, val id: Int, val to: Float, val default: Float, val onChange: (ImageFilterView, Float) -> Unit)