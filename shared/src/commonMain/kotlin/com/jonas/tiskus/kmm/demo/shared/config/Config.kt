package com.jonas.tiskus.kmm.demo.shared.config

class Config(environment: Environment) {

    val baseUrl: String = when (environment) {
        Environment.DEV -> BASE_URL_DEV
        Environment.PRODUCTION -> BASE_URL_PROD
    }

    private companion object {
        const val BASE_URL_PROD = "https://cat-fact.herokuapp.com/"
        const val BASE_URL_DEV = "https://cat-fact.herokuapp.com/"
    }
}