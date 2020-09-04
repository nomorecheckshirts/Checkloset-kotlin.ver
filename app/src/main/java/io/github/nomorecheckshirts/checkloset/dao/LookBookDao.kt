package io.github.nomorecheckshirts.checkloset.dao

import androidx.room.*
import io.github.nomorecheckshirts.checkloset.entity.LookBook

@Dao
interface LookBookDao {

    @Query("Select * from LookBook")
    suspend fun getAll(): List<LookBook>

    @Query("Select * from LookBook where id in (:id)")
    suspend fun loadAllByIds(id: Int): List<LookBook>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(vararg lookBook : LookBook)

    @Delete
    suspend fun delete(lookBook : LookBook)
}