package com.olehliskovych.placenote


import com.olehliskovych.placenote.di.DaggerAppComponent

import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication
import io.realm.Realm

class App : DaggerApplication() {

    override fun onCreate() {
        super.onCreate()
        instance = this
        Realm.init(this)
    }

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerAppComponent
                .builder()
                .application(this)
                .build()
    }

    companion object {

        var instance: App? = null
            private set
    }
}
