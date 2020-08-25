package io.github.nomorecheckshirts.checkloset.db

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log
import io.github.nomorecheckshirts.checkloset.MainActivity

class DBHelper (context: Context) :SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VER){

    companion object{
        private val DATABASE_VER=1
        private val DATABASE_NAME="ChecklosetDB.db"

        private val CREATE_CLOTHES_TABLE="Create table Clothes (id integer)"
        private val CREATE_CUSTOMCLOTHES_TABLE="Create table CustomClothes (id integer)"
        private val CREATE_LOOKS_TABLE="Create table Looks (id integer)"
        private val CREATE_LOOKBOOK_TABLE="Create table LookBook (id integer)"
        private val CREATE_DECORATIONS_TABLE="Create table Decorations (id integer)"
        private val CREATE_WEATHER_TABLE="Create table Weather (id integer)"
    }

    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL(CREATE_CLOTHES_TABLE)
        db.execSQL(CREATE_CUSTOMCLOTHES_TABLE)
        db.execSQL(CREATE_LOOKS_TABLE)
        db.execSQL(CREATE_LOOKBOOK_TABLE)
        db.execSQL(CREATE_DECORATIONS_TABLE)
        db.execSQL(CREATE_WEATHER_TABLE)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db!!.execSQL("Drop table if exists Clothes")
        db!!.execSQL("Drop table if exists CustomClothes")
        db!!.execSQL("Drop table if exists Looks")
        db!!.execSQL("Drop table if exists LookBook")
        db!!.execSQL("Drop table if exists Decorations")
        db!!.execSQL("Drop table if exists Weather")
        onCreate(db)
    }
}