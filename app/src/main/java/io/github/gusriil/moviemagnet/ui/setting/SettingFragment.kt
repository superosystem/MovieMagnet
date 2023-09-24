package io.github.gusriil.moviemagnet.ui.setting

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import io.github.gusriil.moviemagnet.ui.common.TmdbTheme
import io.github.gusriil.moviemagnet.ui.common.composeView
import dagger.android.support.DaggerFragment
import javax.inject.Inject

class SettingFragment @Inject
constructor() // Required empty public constructor
    : DaggerFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = composeView {
        TmdbTheme {
            SettingsScreen()
        }
    }
}