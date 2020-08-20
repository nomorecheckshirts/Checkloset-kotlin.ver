package io.github.nomorecheckshirts.checkloset.db

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DBHelper (context: Context) :SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VER){
    companion object{
        private val DATABASE_VER=1
        private val DATABASE_NAME="ChecklosetDB.db"
    }

    override fun onCreate(db: SQLiteDatabase?) {
        val CREATE_TABLE_QUERY=("Create table ")
        db!!.execSQL(CREATE_TABLE_QUERY)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db!!.execSQL("Drop table if exists hello")
        onCreate(db!!)
    }
}