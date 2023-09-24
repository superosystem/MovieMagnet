package io.github.gusriil.moviemagnet.ui.detail

import io.github.gusriil.moviemagnet.domain.model.Cast
import io.github.gusriil.moviemagnet.domain.model.CreditWrapper
import io.github.gusriil.moviemagnet.domain.model.Crew
import io.github.gusriil.moviemagnet.domain.model.Video
import io.github.gusriil.moviemagnet.ui.BaseDetailViewModel
import io.github.gusriil.moviemagnet.ui.detail.DetailViewModel.DetailWrapper
import io.reactivex.Single

open class DetailViewModel(
    trailers: Single<List<Video>>,
    credits: CreditWrapper
) : BaseDetailViewModel<DetailWrapper>(
    Single.zip(trailers, credits.cast, credits.crew) { videos, cast, crew ->
        DetailWrapper(videos, cast, crew)
    }
) {
    class DetailWrapper(
        val videos: List<Video>,
        val cast: List<Cast>,
        val crew: List<Crew>
    )
}