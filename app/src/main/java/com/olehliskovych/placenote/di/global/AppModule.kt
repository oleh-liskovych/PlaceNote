package com.olehliskovych.placenote.di.global

import android.content.Context

import com.olehliskovych.placenote.App
import com.olehliskovych.placenote.di.scopes.AppScope

import dagger.Binds
import dagger.Module

@Module
interface AppModule {

    @AppScope
    @Binds
    fun bindContext(app: App): Context
}
