package io.github.gusriil.moviemagnet.di

import io.github.gusriil.moviemagnet.ui.start.InAppUpdateHandler
import io.github.gusriil.moviemagnet.ui.start.StartActivity
import dagger.Module
import dagger.Provides

@Module
class InAppUpdateModule {

    @Provides
    internal fun provideInAppUpdate(activity: StartActivity): InAppUpdateHandler =
        InAppUpdateHandler(activity)
}