package com.olehliskovych.placenote.di;

import com.olehliskovych.placenote.di.global.FragmentManagerModule;
import com.olehliskovych.placenote.di.scopes.ActivityScope;
import com.olehliskovych.placenote.ui.base.BaseActivity;
import com.olehliskovych.placenote.ui.note.NoteActivity;

import dagger.Binds;
import dagger.Module;

@Module(includes = {FragmentManagerModule.class})
public interface NoteActivityModule {

    @Binds @ActivityScope
    BaseActivity bindBaseActivity(NoteActivity activity);
}
