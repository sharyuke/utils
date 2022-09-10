package com.sharyuke.app

import androidx.recyclerview.widget.RecyclerView
import com.sharyuke.utils.adapterCreate
import com.sharyuke.utils.withRecyclerView

data class ItemSimple(val icon: Int, val name: String, val onClick: () -> Unit)

fun defaultList(list: List<ItemSimple>, recyclerView: RecyclerView) {
    adapterCreate(R.layout.item_simple_txt, list) {
        onHasItem {
            setImageResource(R.id.item_simple_icon, icon)
            setText(R.id.item_simple_name, name)
        }
        onItemClick { item.onClick() }
    }.withRecyclerView(recyclerView)
}