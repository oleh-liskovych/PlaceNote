package com.olehliskovych.placenote.di;

import com.olehliskovych.placenote.App;
import com.olehliskovych.placenote.di.global.ActivityBuildingModule;
import com.olehliskovych.placenote.di.global.AppModule;
import com.olehliskovych.placenote.di.scopes.AppScope;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;

@AppScope
@Component(modules = {
        AndroidSupportInjectionModule.class,
        ActivityBuildingModule.class,
        AppModule.class
})
public interface AppComponent extends AndroidInjector<App> {

    @Component.Builder
    interface AppComponentBuilder {
        @BindsInstance
        AppComponentBuilder application(App app);

        AppComponent build();
    }

    @Override
    void inject(App instance);
}
