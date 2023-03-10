package com.jonas.tiskus.kmm.demo.shared.data.repository

import com.jonas.tiskus.kmm.demo.shared.data.NetworkResult
import com.jonas.tiskus.kmm.demo.shared.data.remote.CatsApi
import com.jonas.tiskus.kmm.demo.shared.domain.model.Fact
import com.jonas.tiskus.kmm.demo.shared.domain.repository.FactsRepository
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.onStart

class FactsRepositoryImpl(
    private val catsApi: CatsApi
): FactsRepository {
    override suspend fun getFacts() = flow<NetworkResult<List<Fact>>> {
            val facts = catsApi.getFacts().map { Fact(it.text ?: "") }
            emit(NetworkResult.Success(facts))
        }.onStart {
            emit(NetworkResult.Loading)
        }.catch {
            // TODO error handling
            emit(NetworkResult.Error(it))
        }
}