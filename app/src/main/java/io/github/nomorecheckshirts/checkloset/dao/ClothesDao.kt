package io.github.nomorecheckshirts.checkloset.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import io.github.nomorecheckshirts.checkloset.entity.Clothes

@Dao
interface ClothesDao {

    @Query("Select * from Clothes")
    fun getAll(): List<Clothes>

    @Query("Select * from Clothes where id in (:id)")
    fun loadAllByIds(id: Int): List<Clothes>

    @Insert
    fun insert(vararg clothes: Clothes)

    @Delete
    fun delete(clothes: Clothes)
}