package com.jonas.tiskus.kmm.demo.shared.presentation

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.cancel
import kotlin.coroutines.CoroutineContext

class CloseableCoroutineScope(override val coroutineContext: CoroutineContext) : Closeable, CoroutineScope {
    override fun close() {
        coroutineContext.cancel()
    }
}