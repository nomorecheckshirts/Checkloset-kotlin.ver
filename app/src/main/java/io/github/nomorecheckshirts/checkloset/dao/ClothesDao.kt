package io.github.nomorecheckshirts.checkloset.dao

import android.content.ContentValues
import android.database.sqlite.SQLiteDatabase
import io.github.nomorecheckshirts.checkloset.MainActivity
import io.github.nomorecheckshirts.checkloset.db.DBHelper
import io.github.nomorecheckshirts.checkloset.entity.Clothes

class ClothesDao {
    private val TABLE_NAME="CLOTHES"
    val allClothes:List<Clothes>
            get(){
                val lstClothes=ArrayList<Clothes>()
                val selectQueryHandler = "Select * from clothes"
                val db: SQLiteDatabase = DBHelper(MainActivity()).writableDatabase
                val cursor = db.rawQuery(selectQueryHandler, null)
                if(cursor.moveToFirst()){
                    do{
                        val clothes=Clothes()
                        //setting clothes

                        lstClothes.add(clothes)
                    }while(cursor.moveToNext())
                }
                db.close()
                return lstClothes
            }

    fun addClothes(clothes:Clothes){
        val db:SQLiteDatabase = DBHelper(MainActivity()).writableDatabase
        val values = ContentValues()

        db.insert(TABLE_NAME, null, values)
        db.close()
    }

    fun updateClothes(clothes:Clothes){
        val db:SQLiteDatabase = DBHelper(MainActivity()).writableDatabase
        val values = ContentValues()

        //db.update(parameters)
        db.close()
    }

    fun deleteClothes(clothes:Clothes){
        val db:SQLiteDatabase = DBHelper(MainActivity()).writableDatabase

        //db.delete(parameters)
        db.close()
    }
}
