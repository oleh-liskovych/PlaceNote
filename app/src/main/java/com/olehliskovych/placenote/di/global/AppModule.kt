package com.olehliskovych.placenote.di.global

import android.content.Context
import com.olehliskovych.placenote.App
import dagger.Binds
import dagger.Module

@Module
interface AppModule {

    @Binds
    fun bindContext(app: App): Context


}
