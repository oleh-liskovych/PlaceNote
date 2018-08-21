package com.olehliskovych.placenote.di.global

import android.content.Context
import com.olehliskovych.placenote.data.repository.room.PNDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
object DatabaseModule {

    @JvmStatic
    @Provides
    fun provideDatabase(context: Context): PNDatabase {
        return PNDatabase.getInstance(context)
    }

    @JvmStatic
    @Singleton
    @Provides
    fun provideNoteDao(database: PNDatabase) = database.NoteDao()

    @JvmStatic
    @Singleton
    @Provides
    fun provideLabelDao(database: PNDatabase) = database.LabelDao()

    @JvmStatic
    @Singleton
    @Provides
    fun provideNoteLabelJoinDao(database: PNDatabase) = database.NoteLabelJoinDao()
}