package com.avast.re.reauth.wtf;

import android.app.Activity;
import com.avast.re.reauth.MainActivity;
import com.avast.re.reauth.MainActivityFragment;
import com.avast.re.reauth.ReauthApplication;
import dagger.Binds;
import dagger.Component;
import dagger.Module;
import dagger.Provides;
import dagger.android.ActivityKey;
import dagger.android.AndroidInjectionModule;
import dagger.android.AndroidInjector;
import dagger.android.ContributesAndroidInjector;
import dagger.multibindings.IntoMap;

import javax.inject.Singleton;

@Module
public abstract class MainActivityModule {
    @ContributesAndroidInjector
    abstract MainActivityFragment mainActivityFragmentInjector();

    @ContributesAndroidInjector
    abstract MainActivity mainActivityInjector();
}