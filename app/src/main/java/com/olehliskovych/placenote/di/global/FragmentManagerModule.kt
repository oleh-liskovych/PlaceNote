package com.olehliskovych.placenote.di.global

import android.support.v4.app.FragmentManager

import com.olehliskovych.placenote.di.scopes.ActivityScope
import com.olehliskovych.placenote.ui.base.BaseActivity

import dagger.Module
import dagger.Provides

@Module
object FragmentManagerModule {

    @JvmStatic
    @ActivityScope // todo: try to remove this annotation and try to backpress after returning from another activity. Aim is to find out if backpress fragment changing will work properly
    @Provides
    fun provideFragmentManager(activity: BaseActivity): FragmentManager {
        return activity.supportFragmentManager
    }

}
