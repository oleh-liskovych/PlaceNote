package com.olehliskovych.placenote.di;

import com.olehliskovych.placenote.di.global.FragmentManagerModule;
import com.olehliskovych.placenote.di.scopes.ActivityScope;
import com.olehliskovych.placenote.di.scopes.FragmentScope;
import com.olehliskovych.placenote.ui.base.BaseFragment;
import com.olehliskovych.placenote.ui.labels.LabelsActivity;
import com.olehliskovych.placenote.ui.labels.LabelsEditFragment;

import dagger.Binds;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module(includes = FragmentManagerModule.class)
public interface LabelsActivityModule {

    @Binds @ActivityScope
    BaseFragment bindBaseActivity(LabelsActivity activity);


    @FragmentScope
    @ContributesAndroidInjector(modules = LabelsEditFragment.class)
    LabelsEditFragment labelsEditFragment();


}
