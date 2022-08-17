package com.sharyuke.app

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.sharyuke.utils.adapterCreate
import com.sharyuke.utils.withRecyclerView

const val DEMO_IMG_1 = "https://img.redocn.com/sheying/20150414/xiyangxiadedahaimeijing_4161285.jpg"
const val DEMO_IMG_2 = "https://lmg.jj20.com/up/allimg/tp01/1ZZH250054149-0-lp.jpg"
const val DEMO_IMG_3 = "https://c-ssl.duitang.com/uploads/blog/201602/07/20160207173124_HijVQ.jpeg"
const val DEMO_IMG_4 = "https://lmg.jj20.com/up/allimg/tp02/1Z9191923035R0-0-lp.jpg"
const val DEMO_IMG_5 = "https://lmg.jj20.com/up/allimg/1114/0G020114924/200G0114924-2-1200.jpg"

class ViewListLayoutManagerStaggeredActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_list_layout_manager_staggered)
        title = "StaggeredLayoutManager"
        val list = listOf(
            DEMO_IMG_1, DEMO_IMAGE_URL,
            DEMO_IMG_2, DEMO_IMG_3, DEMO_IMG_4, DEMO_IMG_5,
            DEMO_IMG_1, DEMO_IMAGE_URL,
            DEMO_IMG_4, DEMO_IMG_5, DEMO_IMG_4, DEMO_IMG_5,
            DEMO_IMG_4, DEMO_IMG_5, DEMO_IMG_1, DEMO_IMAGE_URL,
            DEMO_IMG_2, DEMO_IMG_3, DEMO_IMG_4, DEMO_IMG_5,
            DEMO_IMG_1, DEMO_IMAGE_URL,
            DEMO_IMG_4, DEMO_IMG_5, DEMO_IMG_1, DEMO_IMAGE_URL,
            DEMO_IMG_2, DEMO_IMG_3, DEMO_IMG_4, DEMO_IMG_5,
        )
        adapterCreate(R.layout.item_staggered_img, list) {
            onHasItem { setImageUrl(R.id.item_staggered_img, this) }
        }.withRecyclerView(findViewById(R.id.view_list_layout_manager_staggered_rv))
    }
}