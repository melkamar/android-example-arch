package com.avast.re.reauth;

import android.app.Activity;
import android.app.Application;
import android.support.v4.app.Fragment;
import com.avast.re.reauth.wtf.DaggerAppComponent;
import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;
import dagger.android.support.DaggerApplication;
import dagger.android.support.HasSupportFragmentInjector;

import javax.inject.Inject;

public class ReauthApplication extends Application implements HasSupportFragmentInjector, HasActivityInjector {

    @Inject
    DispatchingAndroidInjector<Activity> mActivityInjector;

    @Inject
    DispatchingAndroidInjector<Fragment> mFragmentInjector;


    @Override
    public AndroidInjector<Fragment> supportFragmentInjector() {
        return mFragmentInjector;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        DaggerAppComponent.create().inject(this);
    }

    @Override
    public AndroidInjector<Activity> activityInjector() {
        return mActivityInjector;
    }

//    @Override
//    public AndroidInjector<Activity> activityInjector() {
//        return mActivityInjector;
//    }
//
//    @Override
//    public AndroidInjector<Fragment> supportFragmentInjector() {
//        return mFragmentInjector;
//    }
}
