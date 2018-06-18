package com.avast.re.reauth;

import android.arch.lifecycle.LiveData;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.Random;
import java.util.concurrent.Executor;

@Singleton
public class UserRepo {
    private final UserDao userDao;
    private final Executor executor;

//    @Inject
    public UserRepo(UserDao userDao, Executor executor) {
        this.userDao = userDao;
        this.executor = executor;
    }

    public LiveData<User> getUser(int id) {
        refreshUser();
        return userDao.get(id);
    }

    private void refreshUser() {
        executor.execute(() -> userDao.save(new User(new Random().nextInt(100000))));
    }
}
