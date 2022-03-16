package com.rathanavoy.plantstore.feature.store

import com.rathanavoy.plantstore.entity.Store

sealed class StoreState {

    object Loading : StoreState()

    object Finished : StoreState()

    data class Result(val stores: MutableList<Store>) : StoreState()

    data class Error(val exception: Exception) : StoreState()

}