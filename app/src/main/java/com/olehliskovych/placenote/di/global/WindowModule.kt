package com.olehliskovych.placenote.di.global

import android.view.Window

import com.olehliskovych.placenote.di.scopes.ActivityScope
import com.olehliskovych.placenote.ui.base.BaseActivity

import dagger.Module
import dagger.Provides

@Module
object WindowModule {

    @JvmStatic
    @ActivityScope
    @Provides
    fun provideWindow(activity: BaseActivity): Window {
        return activity.window
    }
}
