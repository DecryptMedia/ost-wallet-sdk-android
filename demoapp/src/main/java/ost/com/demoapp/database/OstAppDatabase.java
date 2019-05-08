/*
 * Copyright 2019 OST.com Inc
 *
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 */

package ost.com.demoapp.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import ost.com.demoapp.database.daos.OstLogEventDao;
import ost.com.demoapp.entity.OstLogEvent;

@Database(entities = {OstLogEvent.class}, version = 1)
public abstract class OstAppDatabase extends RoomDatabase {

    private static final String DATABASE_NAME = "ost_app_db";

    public abstract OstLogEventDao ostLogEvent();

    private static volatile OstAppDatabase INSTANCE;

    public static OstAppDatabase initDatabase(final Context context) {
        String databasePath = String.format("%s/%s", context.getNoBackupFilesDir(), DATABASE_NAME);
        if (INSTANCE == null) {
            synchronized (OstAppDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            OstAppDatabase.class, databasePath)
                            .allowMainThreadQueries()
                            .addMigrations(
                                    /*Add your migration class object here
                                     * eg: new Migration_1_2(1,2)
                                     * */
                            )
                            .build();
                }
            }
        }
        return INSTANCE;
    }

    public static OstAppDatabase getDatabase() {
        if (INSTANCE == null) {
            throw new RuntimeException("OstSdkDatabase not initialized");
        }
        return INSTANCE;
    }
}