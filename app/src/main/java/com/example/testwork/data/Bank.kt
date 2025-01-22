package com.example.testwork.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@Entity
@JsonClass(generateAdapter = true)
data class Bank(
    @ColumnInfo(name = "city")
    @Json(name = "city")
    var city: String?,
    @ColumnInfo(name = "name")
    @Json(name = "name")
    var name: String?,
    @ColumnInfo(name = "phone")
    @Json(name = "phone")
    var phone: String?,
    @ColumnInfo(name = "url")
    @Json(name = "url")
    var url: String?
)