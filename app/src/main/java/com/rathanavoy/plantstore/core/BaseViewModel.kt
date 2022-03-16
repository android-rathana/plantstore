package com.rathanavoy.plantstore.core

import androidx.lifecycle.ViewModel
import org.koin.core.component.KoinComponent

abstract class BaseViewModel : ViewModel(), KoinComponent {

    override fun onCleared() {
        super.onCleared()
    }

}