package com.wiquert.progresa.di

import androidx.room3.Room
import com.wiquert.progresa.data.AppDatabase
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val databaseModule = module {
    single {
        Room.databaseBuilder(
            context = androidContext(),
            klass = AppDatabase::class.java,
            name = "progresa.db"
        ).build()
    }
    single {
        get<AppDatabase>().studentDao()
    }
}