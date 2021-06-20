package com.android.sample.game.di


import android.content.Context
import com.android.sample.game.GameApplication
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

/**
 * Main component for the application.
 */
@Singleton
@Component(
    modules = [
        NetworkModule::class,
        AndroidSupportInjectionModule::class,
        UtilsModule::class,
        TitleScreenModule::class,
        RegisterModule::class,
        InGameModule::class]
)
interface ApplicationComponent : AndroidInjector<GameApplication> {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance applicationContext: Context): ApplicationComponent
    }
}