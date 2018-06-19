package com.avast.re.reauth.data;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;
import com.avast.re.reauth.model.User;

@Database(
        entities = {User.class},
        version = 1
)
public abstract class ReauthDB extends RoomDatabase {
    public abstract UserDao getUserDao();
}
