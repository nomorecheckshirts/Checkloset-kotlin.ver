package io.github.nomorecheckshirts.checkloset

import android.content.res.AssetManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import io.github.nomorecheckshirts.checkloset.db.AppDatabase
import io.github.nomorecheckshirts.checkloset.entity.DomesticLocation
import java.io.InputStream

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var db= AppDatabase.getInstance(this)
        //var dbList = db!!.customClothesDao().getAll()


        val assetManager: AssetManager = resources.assets
        val inputStream: InputStream = assetManager.open("WeatherLocationData.txt")

        inputStream.bufferedReader().readLines().forEach{
            var token = it.split("\t")
            var input = DomesticLocation(token[0].toLong(), token[1], token[2], token[3], token[4].toInt(), token[5].toInt())

            Log.d("dbTest", input.toString())
            db!!.domesticLocationDao().insert(input)
        }

        var output = db!!.domesticLocationDao().getAll()
        Log.d("dbTest", "$output")
    }
}