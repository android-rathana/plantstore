package com.rathanavoy.plantstore.feature.plant

import android.os.Bundle
import android.view.View
import com.rathanavoy.plantstore.R
import com.rathanavoy.plantstore.core.BaseFragment
import com.rathanavoy.plantstore.core.BaseViewModel
import com.rathanavoy.plantstore.databinding.FragmentPlantDetailBinding

class PlantDetailFragment :
    BaseFragment<BaseViewModel>(BaseViewModel::class, R.layout.fragment_plant_detail) {

    private lateinit var binding: FragmentPlantDetailBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentPlantDetailBinding.bind(view)
    }

}