package com.olehliskovych.placenote.di.global

import com.olehliskovych.placenote.di.LabelsActivityModule
import com.olehliskovych.placenote.di.MainActivityModule
import com.olehliskovych.placenote.di.NoteActivityModule
import com.olehliskovych.placenote.di.scopes.ActivityScope
import com.olehliskovych.placenote.ui.labels.LabelsActivity
import com.olehliskovych.placenote.ui.main.MainActivity
import com.olehliskovych.placenote.ui.note.NoteActivity

import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
interface ActivityBuildingModule {

    @ActivityScope
    @ContributesAndroidInjector(modules = [MainActivityModule::class])
    fun mainActivity(): MainActivity

    @ActivityScope
    @ContributesAndroidInjector(modules = [NoteActivityModule::class, MapModule::class])
    fun noteActivity(): NoteActivity

    @ActivityScope
    @ContributesAndroidInjector(modules = [LabelsActivityModule::class])
    fun labelsActivity(): LabelsActivity

}
