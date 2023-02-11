package com.jonas.tiskus.kmm.demo.shared.data.dto


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class FactDto (
    @SerialName("createdAt")
        val createdAt: String?,
    @SerialName("deleted")
        val deleted: Boolean?,
    @SerialName("_id")
        val id: String?,
    @SerialName("source")
        val source: String?,
    @SerialName("status")
        val statusDto: StatusDto?,
    @SerialName("text")
        val text: String?,
    @SerialName("type")
        val type: String?,
    @SerialName("updatedAt")
        val updatedAt: String?,
    @SerialName("used")
        val used: Boolean?,
    @SerialName("user")
        val user: String?,
    @SerialName("__v")
        val v: Int?
    ) {
        @Serializable
        data class StatusDto(
            @SerialName("sentCount")
            val sentCount: Int?,
            @SerialName("verified")
            val verified: Boolean?
        )
    }