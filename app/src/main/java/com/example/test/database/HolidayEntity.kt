package com.example.test

import androidx.room.*

@Entity(tableName = "holidays")
data class HolidayEntity(
    @PrimaryKey val date: String,
    val name: String,
    val type: String
)

