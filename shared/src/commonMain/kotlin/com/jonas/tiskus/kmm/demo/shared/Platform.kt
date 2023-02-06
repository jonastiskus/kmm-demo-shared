package com.jonas.tiskus.kmm.demo.shared

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform