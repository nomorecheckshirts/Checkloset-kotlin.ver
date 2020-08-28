package io.github.nomorecheckshirts.checkloset.dao

import androidx.room.*
import io.github.nomorecheckshirts.checkloset.entity.CustomClothes

@Dao
interface CustomClothesDao {

    @Query("Select * from CustomClothes")
    suspend fun getAll(): List<CustomClothes>

    @Query("Select * from CustomClothes where id in (:id)")
    suspend fun loadAllByIds(id: Int): List<CustomClothes>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(vararg customClothes: CustomClothes)

    @Delete
    suspend fun delete(customClothes: CustomClothes)
}
