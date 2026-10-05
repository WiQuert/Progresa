package com.wiquert.progresa

import android.app.Application
import com.wiquert.progresa.di.databaseModule
import com.wiquert.progresa.di.repositoryModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class ProgresaApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@ProgresaApplication)
            modules(databaseModule, repositoryModule)
        }
        }
    }