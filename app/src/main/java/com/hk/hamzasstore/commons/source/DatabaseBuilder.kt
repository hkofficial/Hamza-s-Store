package com.hk.hamzasstore.commons.source

import androidx.room.Room
import com.hk.hamzasstore.App

object DatabaseBuilder {

    private var INSTANCE: AppDatabase? = null

    fun getInstance(): AppDatabase {
        return INSTANCE ?: synchronized(this) {
            val instance = Room.databaseBuilder(
                App.instance.applicationContext,
                AppDatabase::class.java,
                "app_database.db"
            ).build()
            INSTANCE = instance

            instance
        }
    }
}