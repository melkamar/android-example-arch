package com.avast.re.reauth;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

@Database(
        entities = {User.class},
        version = 1
)
public abstract class ReauthDB extends RoomDatabase {
}
