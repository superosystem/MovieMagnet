package io.github.gusriil.moviemagnet.ui.person

import io.github.gusriil.moviemagnet.ui.BaseDetailActivity
import dagger.android.support.DaggerFragment
import javax.inject.Inject

class PersonActivity : BaseDetailActivity() {

    @Inject
    lateinit var personFragment: PersonFragment

    override val fragment: DaggerFragment
        get() = personFragment
}
