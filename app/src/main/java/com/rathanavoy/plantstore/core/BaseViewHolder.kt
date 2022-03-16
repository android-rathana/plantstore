package com.rathanavoy.plantstore.core

import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding

abstract class BaseViewHolder(binding: ViewBinding) : RecyclerView.ViewHolder(binding.root) {

    protected val context: Context = binding.root.context

}