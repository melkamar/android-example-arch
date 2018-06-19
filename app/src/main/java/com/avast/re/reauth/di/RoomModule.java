package com.avast.re.reauth.di;

import android.arch.persistence.room.Room;
import com.avast.re.reauth.ReauthApplication;
import com.avast.re.reauth.data.ReauthDB;
import com.avast.re.reauth.data.UserDao;
import com.avast.re.reauth.data.UserRepo;
import dagger.Module;
import dagger.Provides;

import javax.inject.Singleton;
import java.util.concurrent.Executors;

@Module
public class RoomModule {
    private ReauthDB db;

    public RoomModule(ReauthApplication application){
        db = Room.databaseBuilder(application, ReauthDB.class, "reauth.db").fallbackToDestructiveMigration().build();
    }

    @Singleton
    @Provides
    ReauthDB providesReauthDb(){
        return db;
    }

    @Singleton
    @Provides
    UserDao providesUserDao(ReauthDB db){
        return db.getUserDao();
    }

    @Singleton
    @Provides
    UserRepo providesUserRepo(UserDao dao){
        return new UserRepo(dao, Executors.newSingleThreadExecutor());
    }
}
