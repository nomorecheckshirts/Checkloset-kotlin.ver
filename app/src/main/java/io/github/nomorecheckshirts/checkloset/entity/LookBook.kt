package io.github.nomorecheckshirts.checkloset.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDate
import java.time.format.DateTimeFormatter

@Entity(tableName = "LookBook")
data class LookBook (
    @PrimaryKey(autoGenerate = true) var id: Int = 1,
    @ColumnInfo(name = "LookID1") var lookID1: Int = 0,
    @ColumnInfo(name = "LookID2") var lookID2: Int = 0,
    @ColumnInfo(name = "LookID3") var lookID3: Int = 0,
    @ColumnInfo(name = "LookDate") var lookDate: LocalDate = LocalDate.parse("2020-08-20", DateTimeFormatter.ISO_DATE)
)