package com.wiquert.progresa.data

import androidx.room3.Database
import androidx.room3.RoomDatabase

@Database(entities =
    [StudentEntity::class],
    version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun studentDao() : StudentDao
    }