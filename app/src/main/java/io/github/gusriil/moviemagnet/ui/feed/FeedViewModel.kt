package io.github.gusriil.moviemagnet.ui.feed

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import io.github.gusriil.moviemagnet.domain.model.TmdbItem
import io.github.gusriil.moviemagnet.domain.repository.BaseFeedRepository
import io.github.gusriil.moviemagnet.domain.model.FeedWrapper
import io.github.gusriil.moviemagnet.util.Resource
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

open class FeedViewModel<T : TmdbItem>(
    private val repository: BaseFeedRepository<T>
) : ViewModel() {

    private val _stateFlow = MutableStateFlow<Resource<List<FeedWrapper<T>>>>(Resource.Loading)
    val stateFlow: StateFlow<Resource<List<FeedWrapper<T>>>>
        get() = _stateFlow.asStateFlow()

    init {
        refresh()
    }

    fun refresh() {
        viewModelScope.launch {
            repository.result.collect {
                _stateFlow.tryEmit(it)
            }
        }
    }
}