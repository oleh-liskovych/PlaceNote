package com.olehliskovych.placenote.di;

import com.olehliskovych.placenote.di.global.FragmentManagerModule;
import com.olehliskovych.placenote.di.global.WindowModule;
import com.olehliskovych.placenote.di.scopes.ActivityScope;
import com.olehliskovych.placenote.ui.base.BaseActivity;
import com.olehliskovych.placenote.ui.main.MainActivity;

import dagger.Binds;
import dagger.Module;

@Module(includes = {FragmentManagerModule.class, WindowModule.class})
public interface MainActivityModule {

    @Binds @ActivityScope
    BaseActivity bindBaseActivity(MainActivity activity);



}
