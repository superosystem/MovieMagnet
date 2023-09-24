package io.github.gusriil.moviemagnet.ui.feed

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import io.github.gusriil.moviemagnet.domain.model.FeedWrapper
import io.github.gusriil.moviemagnet.domain.model.TmdbItem
import io.github.gusriil.moviemagnet.ui.BaseNavTypeFragment
import io.github.gusriil.moviemagnet.ui.common.ErrorScreen
import io.github.gusriil.moviemagnet.ui.common.ProgressScreen
import io.github.gusriil.moviemagnet.ui.common.TmdbTheme
import io.github.gusriil.moviemagnet.ui.common.composeView
import io.github.gusriil.moviemagnet.util.Resource

abstract class FeedFragment<T : TmdbItem> : BaseNavTypeFragment() {

    protected abstract val viewModel: FeedViewModel<T>

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = composeView {
        TmdbTheme {
            val resource = viewModel.stateFlow.collectAsState().value
            Content(resource = resource)
        }
    }

    @Composable
    private fun Content(resource: Resource<List<FeedWrapper<T>>>) {
        when (resource) {
            is Resource.Loading -> ProgressScreen()
            is Resource.Success -> {
                FeedCollectionList(
                    navType,
                    resource.data
                ) { tmdbItem ->
                    startDetailActivity(tmdbItem)
                }
            }
            is Resource.Error ->
                ErrorScreen(message = resource.message, viewModel::refresh)
        }
    }
}