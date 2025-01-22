package com.example.testwork.di

import android.app.Application
import androidx.room.Room
import com.example.testwork.data.room.AppDatabase
import dagger.Module
import dagger.Provides

@Module
class DatabaseModule {
    @Provides
    fun provideDb(application: Application): AppDatabase {
        return Room.databaseBuilder(
            application,
            AppDatabase::class.java,
            "app_database"
            //"sdfdsfsd"
        ).build()

    }
}