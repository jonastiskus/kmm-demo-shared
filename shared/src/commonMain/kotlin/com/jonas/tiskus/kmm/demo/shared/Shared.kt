package com.jonas.tiskus.kmm.demo.shared

import com.jonas.tiskus.kmm.demo.shared.config.Config
import com.jonas.tiskus.kmm.demo.shared.config.Environment

object Shared {

    lateinit var config: Config

    fun init(environment: Environment) {
        this.config = Config(environment)
    }
}