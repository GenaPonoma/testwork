package com.example.testwork.repository

import android.util.Log
import com.example.testwork.data.Bin
import com.example.testwork.data.room.BinDao
import com.example.testwork.retrofit.retrofit
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class Repository @Inject constructor(
    private val binDao: BinDao
) {
    suspend fun getBin(bin: String): Bin {
        return retrofit.getBin(bin)
    }
    fun getAlLBin(): Flow<List<Bin>> {
        Log.d("BinDao", "Запрашиваем все данные из таблицы bin")
        return binDao.getAllBin()
    }
    fun insertBin(bin: Bin) = binDao.insert(bin)
}


