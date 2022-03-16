package com.rathanavoy.plantstore.feature.plant

import android.app.Activity
import androidx.core.view.marginEnd
import androidx.core.view.marginStart
import com.rathanavoy.plantstore.R
import com.rathanavoy.plantstore.core.BaseViewHolder
import com.rathanavoy.plantstore.databinding.ListItemPlantBinding
import com.rathanavoy.plantstore.entity.Plant
import com.rathanavoy.plantstore.listener.OnItemClickListener
import com.rathanavoy.plantstore.util.extension.formatCurrency
import com.rathanavoy.plantstore.util.extension.getDimen
import com.rathanavoy.plantstore.util.extension.getScreenWidth

class PlantViewHolder(private val binding: ListItemPlantBinding, private val parentMargin: Int) :
    BaseViewHolder(binding) {

    init {
        val itemSize = getItemSize()
        if (itemSize != null) {
            binding.plantThumb.layoutParams = binding.plantThumb.layoutParams.apply {
                width = itemSize
                height = itemSize
            }
        }
    }

    fun bind(plant: Plant, itemClicked: OnItemClickListener<Plant>) {
        with(binding) {
            txtName.text = plant.name
            txtCategory.text = plant.category
            plantThumb.setImageResource(plant.thumb)
            txtStartPrice.text =
                formatCurrency(context.getString(R.string.format_currency), plant.price)
            root.setOnClickListener {
                itemClicked.onItemClicked(plant, adapterPosition)
            }
        }
    }

    private fun getItemSize(): Int? {
        return if (context is Activity) {
            return context.getScreenWidth() / 2 + context.getDimen(R.dimen.item_grid_margin) * 2 -
                    (binding.plantThumb.marginStart +
                            binding.plantThumb.marginEnd +
                            binding.root.marginStart +
                            binding.root.marginEnd +
                            binding.root.paddingStart +
                            binding.root.paddingEnd +
                            parentMargin)
        } else {
            null
        }
    }
}