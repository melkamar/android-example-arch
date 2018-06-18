package com.avast.re.reauth.wtf;


import dagger.Module;
import dagger.Provides;
import dagger.android.support.AndroidSupportInjectionModule;

@Module(includes = MainActivityModule.class)
public abstract class AppModule {
//    @ContributesAndroidInjector(modules = MainActivityModule.class)
//    abstract AndroidInjector.Factory<? extends Activity> bindMainActivityInjectorFactory(MainActivitySubcomponent.Builder builder);
//    abstract MainActivity mainActivityInjector();

    @Provides
    static AppDependency provideAppDependency(){
        return new AppDependency();
    }
}
