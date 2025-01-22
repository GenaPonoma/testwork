package com.example.testwork.data.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.testwork.data.Bin

@Database(entities = [Bin::class], version = 2)

abstract class AppDatabase : RoomDatabase() {
    abstract fun binDao(): BinDao
}