package com.olehliskovych.placenote.di.global

import android.content.Context
import android.location.LocationManager

import com.olehliskovych.placenote.di.scopes.ActivityScope
import com.olehliskovych.placenote.di.scopes.FragmentScope
import com.olehliskovych.placenote.ui.base.BaseActivity

import dagger.Module
import dagger.Provides

@Module
object MapModule {

    @JvmStatic
    @FragmentScope
    @Provides
    fun provideLocationManager(activity: BaseActivity): LocationManager {
        return activity.getSystemService(Context.LOCATION_SERVICE) as LocationManager
    }
}
