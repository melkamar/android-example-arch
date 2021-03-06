package com.avast.re.reauth.di;

import com.avast.re.reauth.ReauthApplication;
import dagger.Component;
import dagger.android.support.AndroidSupportInjectionModule;

import javax.inject.Singleton;

@Singleton
@Component(modules = {
        AppModule.class,
        AndroidSupportInjectionModule.class,
        ViewModelModule.class,
        RoomModule.class
})
public interface AppComponent {
    void inject(ReauthApplication app);
}
