package com.example.testwork.data


import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@Entity(tableName = "bin")
@JsonClass(generateAdapter = true)
data class Bin(
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null,
    @Embedded
    @Json(name = "bank")
    var bank: Bank?,
    @Json(name = "brand")
    @ColumnInfo(name = "brand")
    var brand: String?,
    @Embedded(prefix = "country_")
    @Json(name = "country")
    var country: Country,
    @Embedded(prefix = "number_")
    @Json(name = "number")
    var number: Number?,
    @Json(name = "scheme")
    @ColumnInfo(name = "scheme")
    var scheme: String?,
    @ColumnInfo(name = "type")
    @Json(name = "type")
    var type: String?
)