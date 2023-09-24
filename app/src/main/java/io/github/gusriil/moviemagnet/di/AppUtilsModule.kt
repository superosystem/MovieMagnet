package io.github.gusriil.moviemagnet.di

import android.content.Context
import io.github.gusriil.moviemagnet.util.NetworkUtils
import dagger.Module
import dagger.Provides

@Module
class AppUtilsModule {

    @Provides
    fun provideNetworkUtils(context: Context): NetworkUtils {
        return NetworkUtils(context)
    }
}