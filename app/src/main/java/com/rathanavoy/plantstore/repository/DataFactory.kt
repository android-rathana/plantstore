package com.rathanavoy.plantstore.repository

import com.rathanavoy.plantstore.entity.Animal
import java.util.UUID
import kotlinx.coroutines.delay

object DataFactory {

    suspend fun getAnimals(): List<Animal> {
        return mutableListOf<Animal>().apply {
            for (i in 0..100) {
                val uuid = UUID.randomUUID()
                add(Animal("$i-${uuid}", uuid.toString()))
                delay(5L)
            }
        }
    }

}