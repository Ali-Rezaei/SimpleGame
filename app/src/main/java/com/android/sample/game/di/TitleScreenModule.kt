package com.android.sample.game.di

import com.android.sample.game.fragment.TitleScreen
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class TitleScreenModule {

    @ContributesAndroidInjector
    internal abstract fun titleScreenFragment(): TitleScreen
}