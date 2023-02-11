package com.jonas.tiskus.kmm.demo.shared.data.remote

import com.jonas.tiskus.kmm.demo.shared.data.dto.FactDto

interface CatsApi {
    suspend fun getFacts(): List<FactDto>
}