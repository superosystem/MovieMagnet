package io.github.gusriil.moviemagnet.di

import io.github.gusriil.moviemagnet.domain.model.Movie
import io.github.gusriil.moviemagnet.domain.model.TVShow
import io.github.gusriil.moviemagnet.domain.repository.MovieDetailRepository
import io.github.gusriil.moviemagnet.domain.repository.PersonRepository
import io.github.gusriil.moviemagnet.domain.repository.TVShowDetailRepository
import io.github.gusriil.moviemagnet.domain.repository.BaseFeedRepository
import io.github.gusriil.moviemagnet.repository.*
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
abstract class RepositoryModule {

    @Singleton
    @Binds
    internal abstract fun bindMovieFeedRepository(movieFeedRepository: MovieFeedRepository): BaseFeedRepository<Movie>

    @Singleton
    @Binds
    internal abstract fun bindTVShowFeedRepository(tvShowFeedRepository: TVShowFeedRepository): BaseFeedRepository<TVShow>

    @Singleton
    @Binds
    internal abstract fun bindMovieDetailRepository(movieDetailRepository: MovieDetailRepositoryImpl): MovieDetailRepository

    @Singleton
    @Binds
    internal abstract fun bindTVShowDetailRepository(tvShowDetailRepository: TVShowDetailRepositoryImpl): TVShowDetailRepository

    @Singleton
    @Binds
    internal abstract fun bindPersonRepository(personRepository: PersonRepositoryImpl): PersonRepository
}