package com.rathanavoy.plantstore.feature.plant

import androidx.lifecycle.viewModelScope
import com.rathanavoy.plantstore.core.BaseViewModel
import com.rathanavoy.plantstore.repository.PlantRepository
import com.rathanavoy.plantstore.repository.StoreRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class PlantViewModel(private val repository: PlantRepository) : BaseViewModel() {

    private val _uiState = MutableStateFlow<PlantState>(PlantState.Loading)
    val uiState: StateFlow<PlantState> = _uiState

    fun getPlants() {
        viewModelScope.launch {
            try {
                repository.getPlants().collect {
                    _uiState.value = PlantState.Result(it)
                }
            } catch (e: Exception) {
                _uiState.value = PlantState.Error(e)
            }
        }
    }

}