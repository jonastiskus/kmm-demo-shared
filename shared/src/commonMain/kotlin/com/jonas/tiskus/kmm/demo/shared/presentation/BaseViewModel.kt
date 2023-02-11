package com.jonas.tiskus.kmm.demo.shared.presentation

import kotlinx.coroutines.CoroutineScope

expect abstract class BaseViewModel() {
    val scope: CoroutineScope
    protected open fun onCleared()
}