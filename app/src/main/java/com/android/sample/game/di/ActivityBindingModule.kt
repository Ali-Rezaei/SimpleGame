package com.android.sample.game.di

import com.android.sample.game.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBindingModule {

    @ContributesAndroidInjector(modules = [InGameModule::class])
    internal abstract fun mainActivity(): MainActivity
}