package com.example.testwork.di


import com.example.testwork.data.room.AppDatabase
import com.example.testwork.data.room.BinDao

import dagger.Module
import dagger.Provides

@Module
class DaoModule {
    @Provides
    fun provideBinDao(database: AppDatabase): BinDao {
        return database.binDao()
    }
}