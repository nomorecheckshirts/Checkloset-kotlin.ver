package io.github.nomorecheckshirts.checkloset.dao

import android.content.ContentValues
import android.database.sqlite.SQLiteDatabase
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import io.github.nomorecheckshirts.checkloset.MainActivity
import io.github.nomorecheckshirts.checkloset.db.DBHelper
import io.github.nomorecheckshirts.checkloset.entity.CustomClothes

@Dao
interface CustomClothesDao {

    @Query("Select * from CustomClothes")
    fun getAll(): List<CustomClothes>

    @Query("Select * from CustomClothes where id in (:id)")
    fun loadAllByIds(id: Int): List<CustomClothes>

    @Insert
    fun insertAll(vararg customClothes: CustomClothes)

    @Delete
    fun delete(customClothes: CustomClothes)
}
