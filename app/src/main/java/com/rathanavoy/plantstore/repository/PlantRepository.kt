package com.rathanavoy.plantstore.repository

import com.rathanavoy.plantstore.entity.Plant
import kotlinx.coroutines.flow.Flow

interface PlantRepository {

    fun getPlants(): Flow<MutableList<Plant>>

}