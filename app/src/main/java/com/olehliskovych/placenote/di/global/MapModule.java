package com.olehliskovych.placenote.di.global;

import android.content.Context;
import android.location.LocationManager;

import com.olehliskovych.placenote.di.scopes.ActivityScope;
import com.olehliskovych.placenote.ui.base.BaseActivity;

import dagger.Module;
import dagger.Provides;

@Module
public abstract class MapModule {
    @ActivityScope
    @Provides
    static LocationManager provideLocationManager(BaseActivity activity) {
        return (LocationManager) activity.getSystemService(Context.LOCATION_SERVICE);
    }
}
