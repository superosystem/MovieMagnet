package io.github.gusriil.moviemagnet.di

import androidx.lifecycle.ViewModelProvider
import io.github.gusriil.moviemagnet.domain.model.Credit
import io.github.gusriil.moviemagnet.ui.person.PersonActivity
import io.github.gusriil.moviemagnet.ui.person.PersonFragment
import io.github.gusriil.moviemagnet.ui.person.PersonViewModel
import io.github.gusriil.moviemagnet.util.Constants.CREDIT
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.android.ContributesAndroidInjector

@Module
abstract class PersonModule {

    @ContributesAndroidInjector
    internal abstract fun personFragment(): PersonFragment

    @Binds
    internal abstract fun bindViewModelFactory(factory: PersonViewModel.Factory): ViewModelProvider.Factory

    @Module
    companion object {
        @Provides
        @JvmStatic
        internal fun providePersonWrapper(activity: PersonActivity): Credit =
                activity.intent.extras?.getParcelable(CREDIT)!!
    }
}