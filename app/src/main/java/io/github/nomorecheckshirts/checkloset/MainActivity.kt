package io.github.nomorecheckshirts.checkloset

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.EditText
import androidx.room.Room
import io.github.nomorecheckshirts.checkloset.db.AppDatabase
import io.github.nomorecheckshirts.checkloset.db.DBHelper
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var db :  AppDatabase? = null

        db= AppDatabase.getInstance(this)
        var dbList = db!!.customClothesDao().getAll()
    }
}