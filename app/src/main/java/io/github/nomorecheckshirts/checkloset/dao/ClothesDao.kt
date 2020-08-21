package io.github.nomorecheckshirts.checkloset.dao

import android.content.ContentValues
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import io.github.nomorecheckshirts.checkloset.MainActivity
import io.github.nomorecheckshirts.checkloset.db.DBHelper
import io.github.nomorecheckshirts.checkloset.dto.ClothesDto

class ClothesDao {
    private val TABLE_NAME="CLOTHES"
    val allClothes:List<ClothesDto>
            get(){
                val lstClothes=ArrayList<ClothesDto>()
                val selectQueryHandler = "Select * from clothes"
                val db: SQLiteDatabase = DBHelper(MainActivity()).writableDatabase
                val cursor = db.rawQuery(selectQueryHandler, null)
                if(cursor.moveToFirst()){
                    do{
                        val clothes=ClothesDto()
                        //setting clothes

                        lstClothes.add(clothes)
                    }while(cursor.moveToNext())
                }
                db.close()
                return lstClothes
            }

    fun addClothes(clothes:ClothesDto){
        val db:SQLiteDatabase = DBHelper(MainActivity()).writableDatabase
        val values = ContentValues()

        db.insert(TABLE_NAME, null, values)
        db.close()
    }

    fun updateClothes(clothes:ClothesDto){
        val db:SQLiteDatabase = DBHelper(MainActivity()).writableDatabase
        val values = ContentValues()

        //db.update(parameters)
        db.close()
    }

    fun deleteClothes(clothes:ClothesDto){
        val db:SQLiteDatabase = DBHelper(MainActivity()).writableDatabase

        //db.delete(parameters)
        db.close()
    }
}
