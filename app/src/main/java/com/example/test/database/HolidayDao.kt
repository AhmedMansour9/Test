package com.example.test.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.test.HolidayEntity

@Dao
interface HolidayDao {
    @Query("SELECT * FROM holidays")
    suspend fun getAllHolidays(): List<HolidayEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(holidays: List<HolidayEntity>)
}