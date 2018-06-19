package com.avast.re.reauth.di;

import com.avast.re.reauth.ui.MainActivity;
import com.avast.re.reauth.ui.MainActivityFragment;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class MainActivityModule {
    @ContributesAndroidInjector
    abstract MainActivityFragment mainActivityFragmentInjector();

    @ContributesAndroidInjector
    abstract MainActivity mainActivityInjector();
}