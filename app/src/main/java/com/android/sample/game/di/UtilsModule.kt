package com.android.sample.game.di

import com.android.sample.game.util.scheduler.BaseSchedulerProvider
import com.android.sample.game.util.scheduler.SchedulerProvider
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
abstract class UtilsModule {

    @Singleton
    @Binds
    internal abstract fun bindSchedulerProvider(schedulerProvider: SchedulerProvider): BaseSchedulerProvider
}