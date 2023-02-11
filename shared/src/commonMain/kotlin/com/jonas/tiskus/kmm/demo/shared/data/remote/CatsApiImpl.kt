package com.jonas.tiskus.kmm.demo.shared.data.remote

import com.jonas.tiskus.kmm.demo.shared.Shared
import com.jonas.tiskus.kmm.demo.shared.data.dto.FactDto
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.plugins.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.plugins.logging.*
import io.ktor.client.request.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json

class CatsApiImpl: CatsApi {

    private companion object {
        private val httpClient = HttpClient {
            defaultRequest {
                url(Shared.config.baseUrl)
            }
            expectSuccess = true

            install(ContentNegotiation) {
                json(
                    json = Json {
                        ignoreUnknownKeys = true
                        isLenient = true
                        prettyPrint = true
                    }
                )
            }
            install(Logging) {
                level = LogLevel.ALL
            }
        }
    }

    override suspend fun getFacts(): List<FactDto> {
        return httpClient.get("facts").body()
    }
}