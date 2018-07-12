package com.olehliskovych.placenote.di;

import com.olehliskovych.placenote.di.global.FragmentManagerModule;
import com.olehliskovych.placenote.di.scopes.FragmentScope;

import dagger.Module;

@Module(includes = FragmentManagerModule.class)
public interface MainActivityModule {

//    @FragmentScope

}
