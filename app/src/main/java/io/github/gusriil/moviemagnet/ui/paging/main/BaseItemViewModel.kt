package io.github.gusriil.moviemagnet.ui.paging.main

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import io.github.gusriil.moviemagnet.ui.paging.BaseViewModel
import io.github.gusriil.moviemagnet.domain.model.TmdbItem
import io.github.gusriil.moviemagnet.paging.Listing
import io.github.gusriil.moviemagnet.paging.BasePageKeyRepository

abstract class BaseItemViewModel<T : TmdbItem>(app: Application) : BaseViewModel<T>(app) {

    protected abstract val mainRepoResult : BasePageKeyRepository<T>

    override val repoResult: LiveData<Listing<T>> = liveData {
        emit(mainRepoResult.getItems())
    }
}