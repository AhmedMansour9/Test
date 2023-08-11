package com.example.test.repository

import com.example.test.HolidayEntity
import com.example.test.database.HolidayDao
import com.example.test.model.Holiday
import com.example.test.network.ApiService
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject

class HolidayRepository @Inject constructor(
    private val apiService: ApiService,
    private val holidayDao: HolidayDao,
) {

    suspend fun getHolidays(year: Int, countryCode: String): List<Holiday> {
        val cachedData = holidayDao.getAllHolidays()
        return if (cachedData.isNotEmpty()) {
            cachedData.map { Holiday(it.date, it.name,it.type) }
        } else {
            val newData = apiService.getHolidays(year, countryCode)
            val entities = newData.map { HolidayEntity(it.date, it.name,it.type) }
            holidayDao.insertAll(entities)
            newData
        }
    }
}