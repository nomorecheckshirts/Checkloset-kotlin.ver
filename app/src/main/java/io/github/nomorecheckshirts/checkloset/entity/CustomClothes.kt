package io.github.nomorecheckshirts.checkloset.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "CustomClothes")
data class CustomClothes (
    @PrimaryKey(autoGenerate = true) var id: Int = 1,
    @ColumnInfo(name = "image_file") var imageFile: String = "image.jpeg", // 이미지 정보
    //@ColumnInfo var color: Array<Float> = arrayOf(0.0f, 0.0f, 0.0f), // R G B
    @ColumnInfo(name = "thick") var thick : Int=0,
    @ColumnInfo(name = "kind") var kind : String = "Outer",
    //@ColumnInfo var tag: Array<String> = arrayOf("hello", "world", "it", "is", "for", "tag"),
    @ColumnInfo(name = "note") var note : String = "notes"){

}