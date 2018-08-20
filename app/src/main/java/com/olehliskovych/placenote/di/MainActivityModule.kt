package com.olehliskovych.placenote.di

import android.app.Activity
import com.olehliskovych.placenote.di.global.FragmentManagerModule
import com.olehliskovych.placenote.di.global.MapModule
import com.olehliskovych.placenote.di.global.WindowModule
import com.olehliskovych.placenote.di.scopes.ActivityScope
import com.olehliskovych.placenote.di.scopes.FragmentScope
import com.olehliskovych.placenote.ui.base.BaseActivity
import com.olehliskovych.placenote.ui.main.MainActivity
import com.olehliskovych.placenote.ui.main.list.MainListFragment
import com.olehliskovych.placenote.ui.main.list.MainListFragmentModule
import com.olehliskovych.placenote.ui.main.map.MainMapFragment
import com.olehliskovych.placenote.ui.main.map.MainMapFragmentModule

import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.android.ContributesAndroidInjector

@Module(includes = [
    FragmentManagerModule::class,
    WindowModule::class
])
abstract class MainActivityModule {

    @Binds
    @ActivityScope
    abstract fun bindBaseActivity(activity: MainActivity): BaseActivity

    @FragmentScope
    @ContributesAndroidInjector(modules = [MainMapFragmentModule::class, MapModule::class])
    abstract fun mainMapFragment() : MainMapFragment

    @FragmentScope
    @ContributesAndroidInjector(modules = [MainListFragmentModule::class])
    abstract fun mainListFragment() : MainListFragment

    @Module
    companion object {
        @JvmStatic
        @ActivityScope
        @Provides
        fun provideActivity(activity: MainActivity): Activity {
            return activity
        }
    }
}
