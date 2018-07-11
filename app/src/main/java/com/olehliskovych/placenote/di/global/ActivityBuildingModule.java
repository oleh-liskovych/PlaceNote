package com.olehliskovych.placenote.di.global;

import com.olehliskovych.placenote.di.MainActivityModule;
import com.olehliskovych.placenote.di.scopes.ActivityScope;
import com.olehliskovych.placenote.ui.main.MainActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public interface ActivityBuildingModule {

    @ActivityScope
    @ContributesAndroidInjector(modules = MainActivityModule.class)
    MainActivity mainActivity();

}
