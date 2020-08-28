package io.github.nomorecheckshirts.checkloset.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import io.github.nomorecheckshirts.checkloset.entity.CustomClothes
import io.github.nomorecheckshirts.checkloset.entity.DomesticLocation

@Dao
interface DomesticLocationDao {

    @Query("Select * from DomesticLocation")
    suspend fun getAll(): List<DomesticLocation>

    @Query("Select * from DomesticLocation where code in (:code)")
    suspend fun loadAllByIds(code: Int): List<DomesticLocation>

    @Insert
    suspend fun insert(vararg domesticLocation: DomesticLocation)

    @Delete
    suspend fun delete(domesticLocation: DomesticLocation)
}