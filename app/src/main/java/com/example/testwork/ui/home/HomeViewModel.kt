package com.example.testwork.ui.home


import android.util.Log
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.testwork.data.Bank
import com.example.testwork.data.Bin
import com.example.testwork.data.Country
import com.example.testwork.data.Number
import com.example.testwork.data.room.BinDao
import com.example.testwork.repository.Repository

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.random.Random

class HomeViewModel @Inject constructor(
    private val repository: Repository
) : ViewModel() {
    var searchText = MutableStateFlow("")


    private var _data = MutableStateFlow<List<Bin>>(emptyList())
    val data = _data.asStateFlow()

    fun getBin() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                repository.getBin(searchText.value).let {
                    _data.value = listOf(it)
                }
                delay(1000)
                insertBin()
            } catch (e: Exception) {
                Log.d("error", e.toString())
            }


        }
    }

    private fun insertBin() {
        viewModelScope.launch(Dispatchers.IO) {
            data.value.forEach {
                Log.d("addBin", it.toString())
                repository.insertBin(it)
            }
        }
    }

//    fun randomInt(min: Int = 0, max: Long = Long.MAX_VALUE): Int {
//        return min + (Math.random() * (max - min)).toInt()
//    }
//
//    fun randomString(length: Int = 10): String {
//        val chars = ('A'..'Z') + ('a'..'z')
//        return List(length) { chars.random() }.joinToString("")
//    }
//
//    fun randomPhone(): String {
//        return "+7${randomInt(1000000000, 9999999999)}"
//    }
//
//    fun randomUrl(): String {
//        return "https://www.${randomString()}.com"
//    }
//
//    val countries = listOf("Russia", "USA", "China", "Germany", "France")
//    fun randomCountryName(): String {
//        return countries.random()
//    }
//
//    val countryCodes = listOf("RU", "US", "CN", "DE", "FR")
//    fun randomCountryCode(): String {
//        return countryCodes.random()
//    }
//
//    private fun generateRandomBin(): List<Bin> {
//        val random = Random
//
//        val brands = arrayOf("Visa", "MasterCard", "American Express", "Discover")
//        val schemes = arrayOf("credit", "debit")
//        val types = arrayOf("physical", "virtual")
//
//        return listOf(
//            Bin(
//                id = null,
//                bank = Bank(randomString(), randomUrl(), randomPhone(), null),
//                brand = brands[random.nextInt(brands.size)],
//                country = Country(
//                    randomCountryName(),
//                    randomCountryCode(),
//                    null,
//                    null,
//                    null,
//                    null,
//                    null
//                ),
//                number = Number(randomInt(16, 19), true),
//                scheme = schemes[random.nextInt(schemes.size)],
//                type = types[random.nextInt(types.size)]
//            )
//        )
    //}


}
