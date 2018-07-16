package com.olehliskovych.placenote.di;

import android.support.v4.app.FragmentManager;

import com.olehliskovych.placenote.di.global.FragmentManagerModule;
import com.olehliskovych.placenote.di.scopes.ActivityScope;
import com.olehliskovych.placenote.di.scopes.FragmentScope;
import com.olehliskovych.placenote.ui.base.BaseActivity;
import com.olehliskovych.placenote.ui.main.MainActivity;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;

@Module(includes = FragmentManagerModule.class)
public interface MainActivityModule {

    @Binds @ActivityScope
    BaseActivity bindBaseActivity(MainActivity activity);

}
