package com.rathanavoy.plantstore.listener

fun interface OnItemClickListener<T> {
    fun onItemClicked(items: T, position: Int)
}