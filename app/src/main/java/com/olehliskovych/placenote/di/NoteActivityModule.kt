package com.olehliskovych.placenote.di

import android.app.Activity
import com.olehliskovych.placenote.di.global.FragmentManagerModule
import com.olehliskovych.placenote.di.scopes.ActivityScope
import com.olehliskovych.placenote.di.scopes.FragmentScope
import com.olehliskovych.placenote.ui.base.BaseActivity
import com.olehliskovych.placenote.ui.note.NoteActivity
import com.olehliskovych.placenote.ui.note.details.NoteDetailsFragment
import com.olehliskovych.placenote.ui.note.details.NoteDetailsFragmentModule
import com.olehliskovych.placenote.ui.note.picking.LabelsPickingFragment
import com.olehliskovych.placenote.ui.note.picking.LabelsPickingFragmentModule
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.android.ContributesAndroidInjector

@Module(includes = [FragmentManagerModule::class])
abstract class NoteActivityModule {

    @Binds
    @ActivityScope
    abstract fun bindBaseActivity(activity: NoteActivity): BaseActivity

    @FragmentScope
    @ContributesAndroidInjector(modules = [NoteDetailsFragmentModule::class])
    abstract fun noteDetailsFragment(): NoteDetailsFragment

    @FragmentScope
    @ContributesAndroidInjector(modules = [LabelsPickingFragmentModule::class])
    abstract fun labelsPickingFragment(): LabelsPickingFragment

    @Module
    companion object {
        @JvmStatic
        @ActivityScope
        @Provides
        fun provideActivity(activity: NoteActivity): Activity {
            return activity
        }
    }

}
