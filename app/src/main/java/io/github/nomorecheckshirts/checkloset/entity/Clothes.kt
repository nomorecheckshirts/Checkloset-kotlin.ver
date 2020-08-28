package io.github.nomorecheckshirts.checkloset.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Clothes")
data class Clothes (
    @PrimaryKey(autoGenerate = true) var id: Int = 1,
    @ColumnInfo(name = "image_file") var imageFile: String = "image.jpeg"
)