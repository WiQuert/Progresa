package com.wiquert.progresa.data

import com.wiquert.progresa.domain.repository.StudentRepository
import kotlinx.coroutines.flow.Flow

class StudentRepositoryImpl(private val studentDao : StudentDao) : StudentRepository {
    override fun getAllStudents(): Flow<List<StudentEntity>> {
        return studentDao.getAllStudents()
    }
    override suspend fun insertStudent(student: StudentEntity) {
        studentDao.insertStudent(student)
    }

    override suspend fun deleteStudent(student: StudentEntity) {
        studentDao.deleteStudent(student)
    }

    override suspend fun updateStudent(student: StudentEntity) {
        studentDao.updateStudent(student)
    }

}