package com.rathanavoy.plantstore.repository.local

import com.rathanavoy.plantstore.R
import com.rathanavoy.plantstore.entity.Plant
import com.rathanavoy.plantstore.repository.PlantRepository
import java.util.UUID
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class MockPlantRepositoryImpl : PlantRepository {

    private val storesThumb = listOf(
        R.drawable.ic_store_1,
        R.drawable.ic_store_2,
        R.drawable.ic_store_3,
        R.drawable.ic_store_4,
        R.drawable.ic_store_5,
        R.drawable.ic_store_6,
        R.drawable.ic_store_7
    )

    override fun getPlants(): Flow<MutableList<Plant>> {
        return flow {
            val items = mutableListOf<Plant>()
            var thumbIndex = 0
            for (i in 0..50) {
                items.add(
                    Plant(
                        UUID.randomUUID().toString(),
                        "AI Plant Store",
                        "Indoor",
                        "",
                        "All known as the Swiss cheese plant, is the species flowering paint native to tropical forest of Southern Maxico, smooth to Panama it has been introduce to many tropical area, and has become in Hawaii.",
                        75.00,
                        storesThumb[thumbIndex],
                    )
                )
                thumbIndex++
                if (thumbIndex >= storesThumb.size) {
                    thumbIndex = 0
                }
            }
            emit(items)
        }
    }
}