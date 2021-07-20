package com.android.sample.game.fragment

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.android.support.DaggerFragment
import javax.inject.Inject

open class BaseFragment : DaggerFragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    protected inline fun <reified V : ViewModel> bindViewModel() = lazy {
        ViewModelProvider(this, viewModelFactory).get(V::class.java)
    }
}