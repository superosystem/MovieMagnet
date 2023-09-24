package io.github.gusriil.moviemagnet.paging

import io.github.gusriil.moviemagnet.domain.model.TmdbItem

interface PageKeyRepository<T : TmdbItem> {
    fun getItems(): Listing<T>
}