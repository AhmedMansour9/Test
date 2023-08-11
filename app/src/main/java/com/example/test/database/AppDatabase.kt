package com.example.test.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.test.HolidayEntity

@Database(entities = [HolidayEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun holidayDao(): HolidayDao
}