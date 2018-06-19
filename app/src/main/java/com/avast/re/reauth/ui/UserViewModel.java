package com.avast.re.reauth.ui;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;
import com.avast.re.reauth.data.UserRepo;
import com.avast.re.reauth.model.User;

import javax.inject.Inject;

public class UserViewModel extends ViewModel {
    private LiveData<User> user;
    private UserRepo userRepo;

    @Inject
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

    public void saveUser(User user){
        userRepo.saveUser(user);
    }
}
