package com.rathanavoy.plantstore.feature.store

import androidx.lifecycle.viewModelScope
import com.rathanavoy.plantstore.core.BaseViewModel
import com.rathanavoy.plantstore.repository.StoreRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class StoreViewModel(private val repository: StoreRepository) : BaseViewModel() {

    private val _uiState = MutableStateFlow<StoreState>(StoreState.Loading)
    val uiState: StateFlow<StoreState> = _uiState

    fun getStores() {
        viewModelScope.launch {
            try {
                repository.getStores().collect {
                    _uiState.value = StoreState.Result(it)
                }
            } catch (e: Exception) {
                _uiState.value = StoreState.Error(e)
            }
        }
    }

}