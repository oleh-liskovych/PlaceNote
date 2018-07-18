package com.olehliskovych.placenote.di.global;

import com.olehliskovych.placenote.data.Repository.Repository;
import com.olehliskovych.placenote.data.Repository.realm.RealmManager;
import com.olehliskovych.placenote.di.scopes.AppScope;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import io.realm.Realm;

@Module
public abstract class RealmModule {

    @AppScope
    @Provides
    static Realm provideRealm() {
        return Realm.getDefaultInstance();
    }

    @AppScope
    @Binds
    abstract Repository bindRepository(RealmManager realmManager);

}
