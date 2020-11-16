package io.github.nomorecheckshirts.checkloset.dao

import androidx.room.*
import io.github.nomorecheckshirts.checkloset.entity.DomesticLocation

@Dao
interface DomesticLocationDao {

    @Query("Select * from DomesticLocation")
    suspend fun getAll(): List<DomesticLocation>

    @Query("Select * from DomesticLocation where code in (:code)")
    suspend fun loadAllByIds(code: Int): List<DomesticLocation>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(vararg domesticLocation: DomesticLocation)

    @Delete
    suspend fun delete(domesticLocation: DomesticLocation)
}