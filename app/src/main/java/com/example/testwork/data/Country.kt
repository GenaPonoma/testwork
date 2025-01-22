package com.example.testwork.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
@Entity
@JsonClass(generateAdapter = true)
data class Country(
    @ColumnInfo(name = "alpha2")
    @Json(name = "alpha2")
    var alpha2: String?,
    @ColumnInfo(name = "currency")
    @Json(name = "currency")
    var currency: String?,
    @ColumnInfo(name = "emoji")
    @Json(name = "emoji")
    var emoji: String?,
    @ColumnInfo(name = "latitude")
    @Json(name = "latitude")
    var latitude: Int?,
    @ColumnInfo(name = "longitude")
    @Json(name = "longitude")
    var longitude: Int?,
    @ColumnInfo(name = "name")
    @Json(name = "name")
    var name: String?,
    @ColumnInfo(name = "numeric")
    @Json(name = "numeric")
    var numeric: String?
)