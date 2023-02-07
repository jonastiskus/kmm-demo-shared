package com.jonas.tiskus.kmm.demo.shared.config

class Config(environment: Environment) {

    val baseUrl: String = when (environment) {
        Environment.DEV -> BASE_URL_PROD
        Environment.PRODUCTION -> BASE_URL_PROD
    }

    private companion object {
        const val BASE_URL_PROD = "https://api.dictionaryapi.dev/api/v2/entries/en/"
        const val BASE_URL_DEV = ""
    }
}