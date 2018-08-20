package com.olehliskovych.placenote.di.global

import android.content.Context
import com.olehliskovych.placenote.data.repository.room.PNDatabase
import com.olehliskovych.placenote.di.scopes.AppScope
import dagger.Module
import dagger.Provides

@Module
object DatabaseModule {
    @JvmStatic
    @AppScope
    @Provides
    fun provideDatabase(context: Context) : PNDatabase {
        return PNDatabase.getInstance(context)
    }
}