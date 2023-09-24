package io.github.gusriil.moviemagnet.ui.paging.main.movie

import android.app.Application
import io.github.gusriil.moviemagnet.domain.model.Movie
import io.github.gusriil.moviemagnet.data.network.MovieApi
import io.github.gusriil.moviemagnet.paging.BasePageKeyRepository
import io.github.gusriil.moviemagnet.paging.movie.MoviePageKeyRepository
import io.github.gusriil.moviemagnet.ui.paging.main.BaseItemViewModel
import io.github.gusriil.moviemagnet.domain.model.SortType

class MovieViewModel(
        api: MovieApi,
        sortType: SortType,
        app: Application
) : BaseItemViewModel<Movie>(app = app) {

    override val mainRepoResult: BasePageKeyRepository<Movie> = MoviePageKeyRepository(api = api,
            sortType = sortType,
            retryExecutor = networkIO,
            context = app.applicationContext)
}