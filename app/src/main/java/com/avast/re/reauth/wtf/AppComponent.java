package com.avast.re.reauth.wtf;

import com.avast.re.reauth.ReauthApplication;
import dagger.Component;
import dagger.android.support.AndroidSupportInjectionModule;

import javax.inject.Singleton;

@Singleton
@Component(modules = {AppModule.class, AndroidSupportInjectionModule.class})
public interface AppComponent {
    void inject(ReauthApplication app);
}
