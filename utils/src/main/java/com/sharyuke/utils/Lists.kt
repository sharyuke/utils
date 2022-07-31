package com.sharyuke.utils

import android.view.View
import android.widget.ImageView
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder

/**
 * @see onClick in file Views.kt
 * @see loadUrl in file Views.kt
 */
class EasyHolder<T>(view: View) : BaseViewHolder(view) {
    var item: T? = null
    var adapter: BaseQuickAdapter<T, EasyHolder<T>>? = null

    fun setImage(id: Int, url: String?) = getView<ImageView>(id).loadUrl(url)

    fun onHasItem(block: T.() -> Unit) = item?.apply(block)
    fun onItemClick(itemClick: ItemModel<T>.() -> Unit) = itemView.onClick { item?.apply { itemClick(ItemModel(adapterPosition, this, adapter!!)) } }
}

data class ItemModel<T>(val position: Int, val item: T, val adapter: BaseQuickAdapter<T, EasyHolder<T>>)

fun <T> adapterCreate(layout: Int, initData: List<T>? = null, convert: EasyHolder<T>.() -> Unit): BaseQuickAdapter<T, EasyHolder<T>> = object : BaseQuickAdapter<T, EasyHolder<T>>(layout) {
    override fun convert(holder: EasyHolder<T>, item: T) {
        holder.item = item
        holder.adapter = this
        convert(holder)
    }
}.apply { initData?.apply { addData(this) } }
