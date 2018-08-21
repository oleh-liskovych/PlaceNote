package com.olehliskovych.placenote.di

import com.olehliskovych.placenote.App
import com.olehliskovych.placenote.di.global.ActivityBuildingModule
import com.olehliskovych.placenote.di.global.AppModule
import com.olehliskovych.placenote.di.global.DatabaseModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [
    AndroidSupportInjectionModule::class,
    ActivityBuildingModule::class,
    DatabaseModule::class,
    AppModule::class
])
interface AppComponent : AndroidInjector<App> {

    @Component.Builder
    interface AppComponentBuilder {
        @BindsInstance
        fun application(app: App): AppComponentBuilder

        fun build(): AppComponent
    }

    override fun inject(instance: App)
}
