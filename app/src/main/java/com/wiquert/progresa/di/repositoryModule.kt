package com.wiquert.progresa.di

import com.wiquert.progresa.data.StudentRepositoryImpl
import com.wiquert.progresa.domain.repository.StudentRepository
import org.koin.dsl.module

val repositoryModule = module {
    single<StudentRepository> {
        StudentRepositoryImpl(get())
    }
}