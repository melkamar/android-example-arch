package com.avast.re.reauth;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;

import javax.inject.Inject;

public class UserViewModel extends ViewModel {
    private LiveData<User> user;
    private UserRepo userRepo;

//    @Inject
    public UserViewModel(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public void init(int userId) {
        if (this.user != null) return;
        user = userRepo.getUser(userId);
    }

    public LiveData<User> getUser() {
        return user;
    }
}
