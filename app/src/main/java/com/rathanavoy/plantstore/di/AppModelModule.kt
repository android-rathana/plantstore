package com.rathanavoy.plantstore.di

import com.rathanavoy.plantstore.feature.plant.PlantViewModel
import com.rathanavoy.plantstore.feature.store.StoreViewModel
import com.rathanavoy.plantstore.repository.PlantRepository
import com.rathanavoy.plantstore.repository.StoreRepository
import com.rathanavoy.plantstore.repository.local.MockPlantRepositoryImpl
import com.rathanavoy.plantstore.repository.local.MockStoreRepositoryImpl
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {

}

val viewModelModule = module {

    viewModel { StoreViewModel(get()) }

    viewModel { PlantViewModel(get()) }
}

val repositoryModule = module {

    factory<StoreRepository> { MockStoreRepositoryImpl() }

    factory<PlantRepository> { MockPlantRepositoryImpl() }

}