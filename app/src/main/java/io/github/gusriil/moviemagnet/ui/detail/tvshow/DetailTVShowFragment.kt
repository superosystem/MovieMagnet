package io.github.gusriil.moviemagnet.ui.detail.tvshow

import androidx.lifecycle.ViewModelProvider
import io.github.gusriil.moviemagnet.ui.detail.DetailFragment
import javax.inject.Inject

class DetailTVShowFragment @Inject
constructor() // Required empty public constructor
    : DetailFragment() {

    @Inject
    lateinit var factory: DetailTVShowViewModel.Factory

    override val viewModel
        get() = ViewModelProvider(this, factory)[DetailTVShowViewModel::class.java]
}