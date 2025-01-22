package com.example.testwork.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
@Entity
@JsonClass(generateAdapter = true)
data class Number(
    @ColumnInfo(name = "length")
    @Json(name = "length")
    var length: Int?, // Теперь поле может быть null
    @Json(name = "luhn")
    @ColumnInfo(name = "luhn")
    var luhn: Boolean? // Теперь поле может быть null
)
