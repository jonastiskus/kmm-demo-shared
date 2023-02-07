package com.jonas.tiskus.kmm.demo.shared

import org.junit.Assert.*
import org.junit.Test

class GreetingTest {

    @Test
    fun greetingAndroidIsMentioned() {
        assertTrue(Greeting().greet().contains("Android"))
    }
}