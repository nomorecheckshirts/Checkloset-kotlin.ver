package io.github.nomorecheckshirts.checkloset.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "DomesticLocation")
data class DomesticLocation (
    @PrimaryKey val code: Long,
    @ColumnInfo(name = "Level1") val level1: String,
    @ColumnInfo(name = "Level2") val level2: String,
    @ColumnInfo(name = "Level3") val level3: String,
    @ColumnInfo(name = "x") val x: Int,
    @ColumnInfo(name = "y") val y: Int
)