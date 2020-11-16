package io.github.nomorecheckshirts.checkloset

import android.content.Intent
import android.content.res.AssetManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import android.util.Log
import io.github.nomorecheckshirts.checkloset.db.AppDatabase
import io.github.nomorecheckshirts.checkloset.entity.Clothes
import io.github.nomorecheckshirts.checkloset.entity.DomesticLocation
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.io.InputStream

class MainActivity : AppCompatActivity() {
    var backPressWait : Long = 0

    override fun onBackPressed() {
        if(System.currentTimeMillis() - backPressWait >=2000 ) {
            backPressWait = System.currentTimeMillis()
            Toast.makeText(applicationContext, "Press back one more time to quit", Toast.LENGTH_LONG).show()
        } else {
            finish()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_start.setOnClickListener{
            val intent = Intent(this, CalendarViewActivity::class.java)
            startActivity(intent)
        }

        btn_weatherTest.setOnClickListener {
            val intent = Intent(this, TestActivity::class.java)
            startActivity(intent)

        }

        btn_paint.setOnClickListener {
            var intent = Intent(this, paint_test::class.java)
            startActivity(intent)
        }

        var db= AppDatabase.getInstance(this)

        val assetManager: AssetManager = resources.assets
        val inputStream: InputStream = assetManager.open("WeatherLocationData.txt")

        inputStream.bufferedReader().readLines().forEach {
            var token = it.split("\t")
            var input = DomesticLocation(
                token[0].toLong(),
                token[1],
                token[2],
                token[3],
                token[4].toInt(),
                token[5].toInt()
            )

            CoroutineScope(Dispatchers.IO).launch {
                db!!.domesticLocationDao().insert(input)
            }
        }

        CoroutineScope(Dispatchers.IO).launch{
            var output = db!!.domesticLocationDao().getAll()
        }
    }
}