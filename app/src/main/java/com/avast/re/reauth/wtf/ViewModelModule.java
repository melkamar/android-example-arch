package com.avast.re.reauth.wtf;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import com.avast.re.reauth.ReauthDB;
import com.avast.re.reauth.UserRepo;
import com.avast.re.reauth.UserViewModel;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import dagger.multibindings.IntoMap;

@Module
public abstract class ViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(UserViewModel.class)
    abstract ViewModel bindUserViewModel(UserViewModel userViewModel);

    @Binds
    abstract ViewModelProvider.Factory bindUserViewModelFactory(ViewModelFactory factory);
}
