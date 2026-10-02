package com.wiquert.progresa.domain.repository

import com.wiquert.progresa.data.StudentEntity
import kotlinx.coroutines.flow.Flow

interface StudentRepository {
    fun getAllStudents() : Flow<List<StudentEntity>>
    suspend fun insertStudent(student: StudentEntity)
    suspend fun updateStudent(student: StudentEntity)
    suspend fun deleteStudent(student: StudentEntity)

}