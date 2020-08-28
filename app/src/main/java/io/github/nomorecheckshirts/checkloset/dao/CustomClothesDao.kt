package io.github.nomorecheckshirts.checkloset.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import io.github.nomorecheckshirts.checkloset.entity.CustomClothes

@Dao
interface CustomClothesDao {

    @Query("Select * from CustomClothes")
    suspend fun getAll(): List<CustomClothes>

    @Query("Select * from CustomClothes where id in (:id)")
    suspend fun loadAllByIds(id: Int): List<CustomClothes>

    @Insert
    suspend fun insert(vararg customClothes: CustomClothes)

    @Delete
    suspend fun delete(customClothes: CustomClothes)
}
