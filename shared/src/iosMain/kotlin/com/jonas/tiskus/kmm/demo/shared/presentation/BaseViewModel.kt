package com.jonas.tiskus.kmm.demo.shared.presentation

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob

actual abstract class BaseViewModel actual constructor() {
    private var hasCleared = false

    actual val scope: CoroutineScope by lazy {
        val scope = CloseableCoroutineScope(SupervisorJob() + Dispatchers.Main.immediate)

        if (hasCleared) closeWithRuntimeException(scope)

        return@lazy scope
    }

    protected actual open fun onCleared() {}

    fun clear() {
        hasCleared = true
        onCleared()
    }

    companion object {
        private fun closeWithRuntimeException(obj: Any?) {
            if (obj is Closeable) {
                try {
                    obj.close()
                } catch (e: Exception) {
                    throw RuntimeException(e)
                }
            }
        }
    }
}