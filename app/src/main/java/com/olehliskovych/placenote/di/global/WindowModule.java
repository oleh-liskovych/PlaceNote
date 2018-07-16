package com.olehliskovych.placenote.di.global;

import android.view.Window;

import com.olehliskovych.placenote.di.scopes.ActivityScope;
import com.olehliskovych.placenote.ui.base.BaseActivity;

import dagger.Module;
import dagger.Provides;

@Module
public abstract class WindowModule {
    @ActivityScope
    @Provides
    static Window provideWindow(BaseActivity activity) {
        return activity.getWindow();
    }
}
