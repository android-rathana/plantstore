package com.rathanavoy.plantstore.feature.plant

import com.rathanavoy.plantstore.entity.Plant

sealed class PlantState {

    object Loading : PlantState()

    object Finished : PlantState()

    data class Result(val plants: MutableList<Plant>) : PlantState()

    data class Error(val exception: Exception) : PlantState()

}