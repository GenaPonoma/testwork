package com.example.testwork.retrofit

import com.example.testwork.data.Bin
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

private const val BASE_URL = "https://lookup.binlist.net/"

val retrofit = Retrofit.Builder()
    .baseUrl(BASE_URL)
    .addConverterFactory(MoshiConverterFactory.create())
    .build()
    .create(GeBin::class.java)

interface GeBin {
    @GET("{bin}")
    suspend fun getBin(@Path("bin") bin: String): Bin
}
