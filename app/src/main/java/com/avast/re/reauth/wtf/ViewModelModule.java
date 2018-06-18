package com.avast.re.reauth.wtf;

import android.arch.lifecycle.ViewModel;
import com.avast.re.reauth.UserViewModel;
import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

//@Module
abstract class ViewModelModule {
//    @Binds
//    @IntoMap
//    @ViewModelKey(UserViewModel.class)
    abstract ViewModel bindUserViewModel(UserViewModel userViewModel);
}
