package com.avast.re.reauth.wtf;


import android.app.Activity;
import com.avast.re.reauth.MainActivity;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import dagger.android.AndroidInjector;
import dagger.android.ContributesAndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;

@Module(includes = {
        MainActivityModule.class,

})
public abstract class AppModule {
//    @Binds
//    abstract AndroidInjector.Factory<? extends Activity> bindMainActivityInjectorFactory();

    @Provides
    static AppDependency provideAppDependency(){
        return new AppDependency();
    }
}
