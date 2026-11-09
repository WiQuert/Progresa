package com.wiquert.progresa.ui.student_list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.wiquert.progresa.domain.repository.StudentRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn

class StudentListViewModel(private val repository: StudentRepository) : ViewModel() {
    private val studentsFlow: Flow<StudentListUiState> =
        repository.getAllStudents()
            .map { students ->
                StudentListUiState.Success(students)
            }

    val uiState: StateFlow<StudentListUiState> =
        studentsFlow
            .catch { error ->
                emit(
                    StudentListUiState.Error(
                        message = error.message ?: "Произошла неизвестная ошибка"
                    )
                )
            }
            .stateIn(        // ← 3
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(5_000),
                initialValue = StudentListUiState.Loading
            )
}