package com.wiquert.progresa.ui.student_list

import com.wiquert.progresa.data.StudentEntity

sealed interface StudentListUiState {
        object Loading : StudentListUiState
        data class Success(val students: List<StudentEntity>) : StudentListUiState
        data class Error(val message: String) : StudentListUiState
}