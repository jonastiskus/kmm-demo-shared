package com.jonas.tiskus.kmm.demo.shared

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class GreetingTest {

    @Test
    fun greetingIosIsMentioned() {
        assertTrue(Greeting().greet().contains("iOS"))
    }
}