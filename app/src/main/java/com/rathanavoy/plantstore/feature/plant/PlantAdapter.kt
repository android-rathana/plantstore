package com.rathanavoy.plantstore.feature.plant

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.marginEnd
import androidx.core.view.marginStart
import com.rathanavoy.plantstore.core.BaseAdapter
import com.rathanavoy.plantstore.core.BaseViewHolder
import com.rathanavoy.plantstore.databinding.ListItemPlantBinding
import com.rathanavoy.plantstore.entity.Plant
import com.rathanavoy.plantstore.listener.OnItemClickListener

class PlantAdapter(
    private val plants: MutableList<Plant>,
    private val itemClickListener: OnItemClickListener<Plant>
) : BaseAdapter<Plant>(plants) {

    override fun onBindChildViewHolder(holder: BaseViewHolder, position: Int) {
        (holder as PlantViewHolder).bind(plants[position], itemClickListener)
    }

    override fun onCreateChildViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        return PlantViewHolder(
            ListItemPlantBinding.inflate(LayoutInflater.from(parent.context), parent, false),
            parent.paddingStart + parent.paddingEnd + parent.marginStart + parent.marginEnd
        )
    }

}