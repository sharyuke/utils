package com.sharyuke.app

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.google.android.flexbox.FlexDirection
import com.google.android.flexbox.FlexWrap
import com.google.android.flexbox.FlexboxLayoutManager
import com.google.android.flexbox.JustifyContent
import com.sharyuke.utils.adapterCreate

/**
 * 所需依赖  "com.google.android.flexbox:flexbox:3.0.0" //Android官方流式布局
 * @see
 */
class ViewListLayoutManagerFlexActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_list_layout_manager_flex)
        title = "FlexLayoutManager"
        findViewById<RecyclerView>(R.id.view_list_layout_manager_flex_rv).apply {
            setFlexLayoutManagerNormal()
            val list = listOf("苹果", "梨", "香蕉", "菠萝", "草莓", "桔子", "橙", "木瓜", "西瓜", "哈密瓜", "香瓜", "甘蔗", "马蹄", "人参果", "柠檬", "火龙果", "提子", "葡萄", "芒果", "枇杷", "桃", "李", "樱桃", "番石榴", "榴莲", "石榴", "柿子", "杏子", "油桃", "菠萝蜜", "梅子", "无花果", "弥猴桃", "扬桃", "柚子", "红枣", "荔枝", "龙眼", "桑椹", "板粟", "山竹", "木竹", "山渣", "椰子", "海棠", "沙梨", "番鬼荔枝", "红毛丹", "沙梨")
            adapter = adapterCreate(R.layout.item_single_txt, list.plus(list).plus(list)) { onHasItem { setText(R.id.item_single_txt, this) } }
        }
    }
}

private fun RecyclerView.setFlexLayoutManagerNormal() {
    val flm = FlexboxLayoutManager(context)
    flm.flexDirection = FlexDirection.ROW
    flm.flexWrap = FlexWrap.WRAP
    flm.justifyContent = JustifyContent.FLEX_START
    layoutManager = flm
}
