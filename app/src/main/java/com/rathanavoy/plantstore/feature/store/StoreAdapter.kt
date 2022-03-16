package com.rathanavoy.plantstore.feature.store

import android.view.LayoutInflater
import android.view.ViewGroup
import com.rathanavoy.plantstore.core.BaseAdapter
import com.rathanavoy.plantstore.core.BaseViewHolder
import com.rathanavoy.plantstore.databinding.ListItemStoreBinding
import com.rathanavoy.plantstore.entity.Store
import com.rathanavoy.plantstore.listener.OnItemClickListener

class StoreAdapter(
    private val stores: MutableList<Store>,
    private val itemClickListener: OnItemClickListener<Store>
) : BaseAdapter<Store>(stores) {

    override fun onBindChildViewHolder(holder: BaseViewHolder, position: Int) {
        (holder as StoreViewHolder).bind(stores[position], itemClickListener)
    }

    override fun onCreateChildViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        return StoreViewHolder(
            ListItemStoreBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

}