package com.rathanavoy.plantstore.repository.local

import com.rathanavoy.plantstore.R
import com.rathanavoy.plantstore.entity.Store
import com.rathanavoy.plantstore.repository.StoreRepository
import java.util.UUID
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class MockStoreRepositoryImpl : StoreRepository {

    private val storesThumb = listOf(
        R.drawable.ic_store_1,
        R.drawable.ic_store_2,
        R.drawable.ic_store_3,
        R.drawable.ic_store_4,
        R.drawable.ic_store_5,
        R.drawable.ic_store_6,
        R.drawable.ic_store_7
    )

    override fun getStores(): Flow<MutableList<Store>> {
        return flow {
            val items = mutableListOf<Store>()
            var thumbIndex = 0
            for (i in 0..50) {
                items.add(
                    Store(
                        UUID.randomUUID().toString(),
                        "AI Plant Store",
                        "Boeng Salang, Phnom Penh",
                        "",
                        5.0F,
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