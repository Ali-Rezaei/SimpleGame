package com.android.sample.game.di

import com.android.sample.game.fragment.Register
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class RegisterModule {

    @ContributesAndroidInjector
    internal abstract fun registerFragment(): Register
}