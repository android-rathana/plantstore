package com.rathanavoy.plantstore.core

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

abstract class BaseAdapter<MODEL>(val items: MutableList<MODEL>) :
    RecyclerView.Adapter<BaseViewHolder>() {

    abstract fun onBindChildViewHolder(holder: BaseViewHolder, position: Int)

    abstract fun onCreateChildViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        onBindChildViewHolder(holder, position)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        return onCreateChildViewHolder(parent, viewType)
    }

    override fun getItemCount(): Int = items.size

    fun add(item: MODEL, position: Int = 0) {
        items.add(position, item)
        notifyItemInserted(position)
    }

    fun addMore(items: MutableList<MODEL>) {
        val previousSize = this.items.size
        this.items.addAll(items)
        notifyItemRangeInserted(previousSize, this.items.size)
    }

    fun update(newItem: MODEL, position: Int) {
        items[position] = newItem
        notifyItemChanged(position)
    }

    fun remove(item: MODEL, position: Int) {
        items.remove(item)
        notifyItemRemoved(position)
    }

}