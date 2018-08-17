package com.olehliskovych.placenote.di.global

import com.olehliskovych.placenote.data.Repository.Repository
import com.olehliskovych.placenote.data.Repository.realm.RealmManager
import com.olehliskovych.placenote.di.scopes.AppScope

import dagger.Binds
import dagger.Module
import dagger.Provides
import io.realm.Realm

@Module
abstract class RealmModule {

    @AppScope
    @Binds
    abstract fun bindRepository(realmManager: RealmManager): Repository

    @Module
    companion object {
        @JvmStatic
        @AppScope
        @Provides
        fun provideRealm(): Realm {
            return Realm.getDefaultInstance()
        }
    }

}
