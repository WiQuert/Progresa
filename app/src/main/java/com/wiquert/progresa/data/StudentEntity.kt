package com.wiquert.progresa.data

import androidx.room3.Entity
import androidx.room3.PrimaryKey

@Entity(tableName = "students")
data class StudentEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val name: String = "",
    val lessonFormat: String = "",
    val subject: String = "",
    val grade: String = "",
    val lessonPrice: Int = 0,
    val phoneNumber: String = ""
)
