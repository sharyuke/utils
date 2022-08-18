package com.sharyuke.app.ui

import android.os.Bundle
import android.view.ViewStub
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.imageview.ShapeableImageView
import com.google.android.material.shape.CornerFamily.CUT
import com.google.android.material.shape.CornerFamily.ROUNDED
import com.google.android.material.shape.ShapeAppearanceModel
import com.google.android.material.slider.Slider
import com.sharyuke.app.R
import com.sharyuke.utils.EasyHolder
import com.sharyuke.utils.adapterCreate
import com.sharyuke.utils.loadUrl
import com.sharyuke.utils.withRecyclerView

/**
 * 功能：实现对图片四个角的圆角 切角，可以单独控制，但是不能进行图片的滤镜功能。
 *
 * 相比ImageFilterView 这个ImageView，切角原价功能更多，但是也更复杂，大多数情况用ImageFilterView即可，如果对不同的角，有不同的切片形状，可以用此View实现。
 */
class ViewImageShapeableActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_image_shape)
        title = "ImageShapeableView"
        val list = listOf(
            ItemImageShape("圆角", R.layout.item_view_image_shapeable_1, R.id.item_view_image_shapeable_img_1, 1f, .5f) { s, h, f ->
                s.shapeAppearanceModel = ShapeAppearanceModel().withCornerSize {
                    h.setText(R.id.item_view_image_shapeable_name, String.format("%s：%.2f", h.item?.name, f))
                    it.width() * f
                }
            },
            ItemImageShape("切角", R.layout.item_view_image_shapeable_2, R.id.item_view_image_shapeable_img_2, 1f, .5f) { s, h, f ->
                s.shapeAppearanceModel = ShapeAppearanceModel.builder().setAllCorners(CUT, 0f).build().withCornerSize {
                    h.setText(R.id.item_view_image_shapeable_name, String.format("%s：%.2f", h.item?.name, f))
                    it.width() * f
                }
            },
            ItemImageShape("更复杂", R.layout.item_view_image_shapeable_3, R.id.item_view_image_shapeable_img_3, 1f, .5f) { s, h, f ->
                s.shapeAppearanceModel = ShapeAppearanceModel.builder().setBottomLeftCorner(CUT, 0f)
                    .setBottomRightCorner(ROUNDED, 0f)
                    .setTopLeftCorner(ROUNDED, 0f)
                    .setTopRightCorner(CUT, 0f)
                    .build().withCornerSize {
                        h.setText(R.id.item_view_image_shapeable_name, String.format("%s：%.2f", h.item?.name, f))
                        it.width() * f
                    }
            },
        )
        adapterCreate(R.layout.item_view_image_shapeable, list) {
            onHasItem {
                val imageView = getView<ViewStub>(R.id.item_view_image_shapeable_img).inflateAndFindView<ShapeableImageView>(layout, id)
                setText(R.id.item_view_image_shapeable_name, String.format("%s：%.2f", name, default))
                imageView.loadUrl(DEMO_IMAGE_URL)
                val slider = getView<Slider>(R.id.item_view_image_shapeable_slider)
                slider.valueFrom = 0f
                slider.valueTo = to
                slider.value = default
                slider.addOnChangeListener { _, value, _ -> item?.onChange?.let { it(imageView, this@adapterCreate, value) } }
            }
        }.withRecyclerView(findViewById(R.id.view_image_shapeable_rv))

    }
}

data class ItemImageShape(val name: String, val layout: Int, val id: Int, val to: Float, val default: Float, val onChange: (ShapeableImageView, EasyHolder<ItemImageShape>, Float) -> Unit)