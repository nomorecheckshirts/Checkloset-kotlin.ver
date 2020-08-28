package io.github.nomorecheckshirts.checkloset.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "CustomClothes")
data class CustomClothes (
    @PrimaryKey(autoGenerate = true) var id: Int = 1,
    @ColumnInfo(name = "image_file") var imageFile: String = "image.jpeg", // 이미지 정보
    @ColumnInfo(name = "colorR") var colorR: Float = 0.0f,
    @ColumnInfo(name = "colorG") var colorG: Float = 0.0f,
    @ColumnInfo(name = "colorB") var colorB: Float = 0.0f,
    @ColumnInfo(name = "thick") var thick : Int=0,
    @ColumnInfo(name = "kind") var kind : String = "Outer",
    @ColumnInfo(name = "tag") var tag: String = "tag",
    @ColumnInfo(name = "note") var note : String = "notes"
)