package com.wiquert.progresa.di

import com.wiquert.progresa.ui.student_list.StudentListViewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val viewModelModule = module {
    viewModelOf(::StudentListViewModel)
}