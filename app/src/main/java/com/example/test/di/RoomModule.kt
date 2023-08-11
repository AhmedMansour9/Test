package com.example.test.di

import android.content.Context
import androidx.room.Room
import com.example.test.database.AppDatabase
import com.example.test.database.HolidayDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RoomModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): AppDatabase {
        return Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            "holiday-database"
        ).build()
    }

    @Provides
    @Singleton
    fun provideHolidayDao(database: AppDatabase): HolidayDao {
        return database.holidayDao()
    }
}