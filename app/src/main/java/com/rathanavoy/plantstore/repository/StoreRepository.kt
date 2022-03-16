package com.rathanavoy.plantstore.repository

import com.rathanavoy.plantstore.entity.Store
import kotlinx.coroutines.flow.Flow

interface StoreRepository {

    fun getStores(): Flow<MutableList<Store>>

}