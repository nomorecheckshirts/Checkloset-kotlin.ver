package io.github.nomorecheckshirts.checkloset.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import io.github.nomorecheckshirts.checkloset.dao.ClothesDao
import io.github.nomorecheckshirts.checkloset.dao.CustomClothesDao
import io.github.nomorecheckshirts.checkloset.dao.DomesticLocationDao
import io.github.nomorecheckshirts.checkloset.entity.Clothes
import io.github.nomorecheckshirts.checkloset.entity.CustomClothes
import io.github.nomorecheckshirts.checkloset.entity.DomesticLocation

@Database(entities = [Clothes::class, CustomClothes::class, DomesticLocation::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun clothesDao() : ClothesDao
    abstract fun customClothesDao() : CustomClothesDao
    abstract fun domesticLocationDao() : DomesticLocationDao

    companion object {
        private var instance: AppDatabase? = null

        @Synchronized
        fun getInstance(context: Context): AppDatabase? {
            if (instance == null) {
                instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "ChecklosetDB.db"
                ).build()
            }
            return instance
        }
    }
}