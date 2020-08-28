package io.github.nomorecheckshirts.checkloset.dao

import androidx.room.*
import io.github.nomorecheckshirts.checkloset.entity.Clothes

@Dao
interface ClothesDao {

    @Query("Select * from Clothes")
    suspend fun getAll(): List<Clothes>

    @Query("Select * from Clothes where id in (:id)")
    suspend fun loadAllByIds(id: Int): List<Clothes>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(vararg clothes: Clothes)

    @Delete
    suspend fun delete(clothes: Clothes)
}