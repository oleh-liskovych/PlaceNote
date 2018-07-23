package com.olehliskovych.placenote.di;

import android.app.Activity;
import android.content.Context;

import com.olehliskovych.placenote.di.global.FragmentManagerModule;
import com.olehliskovych.placenote.di.scopes.ActivityScope;
import com.olehliskovych.placenote.di.scopes.FragmentScope;
import com.olehliskovych.placenote.ui.base.BaseActivity;
import com.olehliskovych.placenote.ui.note.NoteActivity;
import com.olehliskovych.placenote.ui.note.details.NoteDetailsFragment;
import com.olehliskovych.placenote.ui.note.details.NoteDetailsFragmentModule;
import com.olehliskovych.placenote.ui.note.picking.LabelsPickingFragment;
import com.olehliskovych.placenote.ui.note.picking.LabelsPickingFragmentModule;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import dagger.android.ContributesAndroidInjector;

@Module(includes = {FragmentManagerModule.class})
public interface NoteActivityModule {

    @Binds @ActivityScope
    BaseActivity bindBaseActivity(NoteActivity activity);

    @FragmentScope
    @ContributesAndroidInjector(modules = NoteDetailsFragmentModule.class)
    NoteDetailsFragment noteDetailsFragment();

    @FragmentScope
    @ContributesAndroidInjector(modules = LabelsPickingFragmentModule.class)
    LabelsPickingFragment labelsPickingFragment();

    @ActivityScope
    @Provides
    static Activity provideActivity(NoteActivity activity){
        return activity;
    }

}
