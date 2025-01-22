package com.example.testwork.data.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.testwork.data.Bin
import kotlinx.coroutines.flow.Flow

@Dao
interface BinDao {
    @Query("SELECT * FROM bin")
    fun getAllBin() : Flow<List<Bin>>

    @Insert(entity = Bin::class)
    fun insert(bin: Bin)
}