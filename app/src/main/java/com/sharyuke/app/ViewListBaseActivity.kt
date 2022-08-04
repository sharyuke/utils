package com.sharyuke.app

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.sharyuke.utils.EasyHolder
import com.sharyuke.utils.ItemModel
import com.sharyuke.utils.adapterCreate

class ViewListBaseActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_list_base)
        title = "简单列表"
        var times = 0
        val list = listOf(
            ItemListBase("基础操作") { easeHolder, itemModel -> easeHolder.setText(R.id.item_simple_txt, String.format("%s 点击了%d", itemModel.item.name, times++)) },
            ItemListBase("独立操作") { easeHolder, itemModel -> easeHolder.setText(R.id.item_simple_txt, String.format("%s 点击了%d", itemModel.item.name, itemModel.item.times++)) },
            ItemListBase("基础操作") { easeHolder, itemModel -> easeHolder.setText(R.id.item_simple_txt, String.format("%s 点击了%d", itemModel.item.name, times++)) },
            ItemListBase("基础操作") { easeHolder, itemModel -> easeHolder.setText(R.id.item_simple_txt, String.format("%s 点击了%d", itemModel.item.name, times++)) },
            ItemListBase("基础操作") { easeHolder, itemModel -> easeHolder.setText(R.id.item_simple_txt, String.format("%s 点击了%d", itemModel.item.name, times++)) },
            ItemListBase("基础操作") { easeHolder, itemModel -> easeHolder.setText(R.id.item_simple_txt, String.format("%s 点击了%d", itemModel.item.name, times++)) },
            ItemListBase("基础操作") { easeHolder, itemModel -> easeHolder.setText(R.id.item_simple_txt, String.format("%s 点击了%d", itemModel.item.name, times++)) },
            ItemListBase("基础操作") { easeHolder, itemModel -> easeHolder.setText(R.id.item_simple_txt, String.format("%s 点击了%d", itemModel.item.name, times++)) },
            ItemListBase("基础操作") { easeHolder, itemModel -> easeHolder.setText(R.id.item_simple_txt, String.format("%s 点击了%d", itemModel.item.name, times++)) },
            ItemListBase("基础操作") { easeHolder, itemModel -> easeHolder.setText(R.id.item_simple_txt, String.format("%s 点击了%d", itemModel.item.name, times++)) },
            ItemListBase("基础操作") { easeHolder, itemModel -> easeHolder.setText(R.id.item_simple_txt, String.format("%s 点击了%d", itemModel.item.name, times++)) },
            ItemListBase("基础操作") { easeHolder, itemModel -> easeHolder.setText(R.id.item_simple_txt, String.format("%s 点击了%d", itemModel.item.name, times++)) },
        )
        findViewById<RecyclerView>(R.id.view_list_base_rv).adapter = adapterCreate(R.layout.item_simple_txt, list) {
            onHasItem {
                setText(R.id.item_simple_txt, name)
                setImageResource(R.id.item_simple_icon, R.mipmap.icon_list)
            }
            onItemClick { item.onClick(this@adapterCreate, this) }
            onItemLongClick { Toast.makeText(this@ViewListBaseActivity, "长按了", Toast.LENGTH_SHORT).show() }
        }
    }
}

data class ItemListBase(val name: String, val onClick: (EasyHolder<ItemListBase>, ItemModel<ItemListBase>) -> Unit) {
    var times = 0
}