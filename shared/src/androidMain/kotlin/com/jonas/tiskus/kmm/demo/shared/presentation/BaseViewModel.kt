package com.jonas.tiskus.kmm.demo.shared.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineScope

actual abstract class BaseViewModel actual constructor(): ViewModel() {
    actual val scope: CoroutineScope = viewModelScope

    actual override fun onCleared() {
        super.onCleared()
    }
}