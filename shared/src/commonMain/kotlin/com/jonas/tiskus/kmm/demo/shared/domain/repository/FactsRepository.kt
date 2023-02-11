package com.jonas.tiskus.kmm.demo.shared.domain.repository

import com.jonas.tiskus.kmm.demo.shared.data.NetworkResult
import com.jonas.tiskus.kmm.demo.shared.domain.model.Fact
import kotlinx.coroutines.flow.Flow

interface FactsRepository {
    suspend fun getFacts(): Flow<NetworkResult<List<Fact>>>
}