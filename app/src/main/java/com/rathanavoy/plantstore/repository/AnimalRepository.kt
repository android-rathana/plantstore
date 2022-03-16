package com.rathanavoy.plantstore.repository

import com.rathanavoy.plantstore.entity.Animal

interface AnimalRepository {

    suspend fun getAnimals(): List<Animal>

}