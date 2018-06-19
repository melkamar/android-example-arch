package com.avast.re.reauth.data;

import android.arch.lifecycle.LiveData;
import com.avast.re.reauth.model.User;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.Random;
import java.util.concurrent.Executor;
import java.util.logging.Logger;

@Singleton
public class UserRepo {
    private final UserDao userDao;
    private final Executor executor;

    @Inject
    public UserRepo(UserDao userDao, Executor executor) {
        this.userDao = userDao;
        this.executor = executor;
    }

    public LiveData<User> getUser(int id) {
        Logger.getLogger(this.getClass().getName()).info("getUser()");
        refreshUser(id);
        LiveData<User> res = userDao.get(id);
        return res;
    }

    public void saveUser(User user) {
        executor.execute(() -> {
            Logger.getLogger(this.getClass().getName()).info("Saving user " + user);
            userDao.save(user);
        });
    }

    private void refreshUser(int id) {
        executor.execute(() -> {
            if (!userDao.exists(id)) {
                User user = new User(new Random().nextInt(100000));
                user.setId(id);
                Logger.getLogger(this.getClass().getName()).info("Saving user EXECUTOR: " + user);
                userDao.save(user);
            }
        });
    }
}
