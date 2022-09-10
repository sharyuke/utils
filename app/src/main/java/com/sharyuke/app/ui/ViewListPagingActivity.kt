package com.sharyuke.app.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.sharyuke.app.R
import com.sharyuke.utils.PAGE_SIZE
import com.sharyuke.utils.adapterPaging
import com.sharyuke.utils.pagingStart
import com.sharyuke.utils.withRecyclerView

class ViewListPagingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_list_paging)
        title = "分页列表"
        adapterPaging<String>(R.layout.item_simple_txt) {
            onHasItem { setText(R.id.item_simple_name, this) }
        }.withRecyclerView(findViewById(R.id.view_list_page_rv))
            .pagingStart(lifecycleScope) { getData(it) }
    }

    private suspend fun getData(page: Int): List<String> {
        return (0 until PAGE_SIZE).map { "当前第$page 页，第 $it 条数据" }
    }
}