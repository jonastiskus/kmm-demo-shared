package com.jonas.tiskus.kmm.demo.shared.presentation

import com.jonas.tiskus.kmm.demo.shared.asCommonFlow
import com.jonas.tiskus.kmm.demo.shared.data.NetworkResult
import com.jonas.tiskus.kmm.demo.shared.data.remote.CatsApiImpl
import com.jonas.tiskus.kmm.demo.shared.data.repository.FactsRepositoryImpl
import com.jonas.tiskus.kmm.demo.shared.domain.model.Fact
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class FactsViewModel: BaseViewModel() {

    private val _state = MutableStateFlow(FactsUiState(isLoading = true))
    val state = _state.asCommonFlow()

    private val repository = FactsRepositoryImpl(CatsApiImpl())

    init {
        fetchFacts()
    }

    private fun fetchFacts() {
        print("fetching facts!")
        scope.launch {
            repository.getFacts().collect {
                when (it) {
                    NetworkResult.Loading -> _state.value = _state.value.copy(isLoading = true)
                    is NetworkResult.Success -> _state.value = FactsUiState(facts = it.data)
                    is NetworkResult.Error -> _state.value = FactsUiState(error = it.throwable)
                }
            }
        }
    }

    fun reload() {
        fetchFacts()
    }

    data class FactsUiState(
        val isLoading: Boolean = false,
        val facts: List<Fact> = emptyList(),
        val error: Throwable? = null
    )
}