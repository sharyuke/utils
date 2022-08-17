package com.sharyuke.app

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.sharyuke.utils.adapterCreate
import com.sharyuke.utils.withRecyclerView

class ViewListLayoutManagerGridActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_list_layout_manager_grid)
        title = "GridLayoutManger"
        val list = listOf(DEMO_IMAGE_URL, DEMO_IMAGE_URL, DEMO_IMAGE_URL, DEMO_IMAGE_URL, DEMO_IMAGE_URL)
        adapterCreate(R.layout.item_simple_img, list) {
            onHasItem { setImageUrl(R.id.item_simple_img, this) }
        }.withRecyclerView(findViewById(R.id.view_list_layout_manager_grid_rv))
    }
}