package com.olehliskovych.placenote.di;

import com.olehliskovych.placenote.di.global.FragmentManagerModule;
import com.olehliskovych.placenote.di.scopes.ActivityScope;
import com.olehliskovych.placenote.di.scopes.FragmentScope;
import com.olehliskovych.placenote.ui.base.BaseActivity;
import com.olehliskovych.placenote.ui.labels.LabelsActivity;
import com.olehliskovych.placenote.ui.labels.LabelsEditFragment;
import com.olehliskovych.placenote.ui.labels.LabelsEditFragmentModule;

import dagger.Binds;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module(includes = FragmentManagerModule.class)
public interface LabelsActivityModule {

    @Binds @ActivityScope
    BaseActivity bindBaseActivity(LabelsActivity activity);


    @FragmentScope
    @ContributesAndroidInjector(modules = LabelsEditFragmentModule.class)
    LabelsEditFragment labelsEditFragment();


}
