package com.rathanavoy.plantstore.repository.local

import com.rathanavoy.plantstore.entity.Animal
import com.rathanavoy.plantstore.repository.AnimalRepository
import com.rathanavoy.plantstore.repository.DataFactory

class MockAnimalRepositoryImpl : AnimalRepository {

    override suspend fun getAnimals(): List<Animal> {
        return DataFactory.getAnimals()
    }

}