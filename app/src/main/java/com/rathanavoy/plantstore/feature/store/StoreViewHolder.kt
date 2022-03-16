package com.rathanavoy.plantstore.feature.store

import com.rathanavoy.plantstore.core.BaseViewHolder
import com.rathanavoy.plantstore.databinding.ListItemStoreBinding
import com.rathanavoy.plantstore.entity.Store
import com.rathanavoy.plantstore.listener.OnItemClickListener

class StoreViewHolder(private val binding: ListItemStoreBinding) : BaseViewHolder(binding) {

    fun bind(store: Store, itemClicked: OnItemClickListener<Store>) {
        with(binding) {
            txtName.text = store.name
            txtLocation.text = store.address
            storeThumb.setImageResource(store.thumb)
            viewRating.rating = store.rating
            txtRating.text = "${store.rating}"
            root.setOnClickListener {
                itemClicked.onItemClicked(store, adapterPosition)
            }
        }
    }

}