package com.jonas.tiskus.kmm.demo.shared.presentation

import com.jonas.tiskus.kmm.demo.shared.asCommonFlow
import com.jonas.tiskus.kmm.demo.shared.data.NetworkResult
import com.jonas.tiskus.kmm.demo.shared.di.di
import com.jonas.tiskus.kmm.demo.shared.domain.model.Fact
import com.jonas.tiskus.kmm.demo.shared.domain.repository.FactsRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import org.kodein.di.instance

class FactsViewModel: BaseViewModel() {

    private val repository: FactsRepository by di.instance()

    private val _state = MutableStateFlow(FactsUiState(isLoading = true))
    val state = _state.asCommonFlow()

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