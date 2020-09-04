package io.github.nomorecheckshirts.checkloset

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_test.*

import io.github.nomorecheckshirts.checkloset.api.WeatherInterface
import io.github.nomorecheckshirts.checkloset.api.WEATHER

import android.util.Log
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.*

val num_of_rows: Int = 100
val page_no: Int = 1
val data_type: String = "JSON"
var base_time: String = "0200"
var base_date: String = "20200101"
// 지역 위치 좌표
var nx: Int = 59
var ny: Int = 125

private val retrofit = Retrofit.Builder()
    .baseUrl("http://apis.data.go.kr/1360000/VilageFcstInfoService/")
    .addConverterFactory(GsonConverterFactory.create())
    .build()

object ApiObject {
    val retrofitService: WeatherInterface by lazy {
        retrofit.create(WeatherInterface::class.java)
    }
}

class TestActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test)

        btn_home.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }

        var currentTime = LocalDateTime.now()
        var dateFormat = DateTimeFormatter.ofPattern("yyyyMMdd")
        var timeFormat = DateTimeFormatter.ofPattern("hhmm")
        var formattedDate: String = currentTime.format(dateFormat)
        var formattedTime: String = currentTime.format(timeFormat)

        //println("Current: $formatted")
        base_date = formattedDate
        //base_time = formattedTime

        println("Current: $base_date, $base_time")

        val call = ApiObject.retrofitService.GetWeather(data_type, num_of_rows, page_no, base_date, base_time, nx, ny)
        call.enqueue(object : retrofit2.Callback<WEATHER>{
            override fun onResponse(call: Call<WEATHER>, response: Response<WEATHER>) {

                var codeValue: String = response.body()!!.response.body.items.item[0].category
                var fcstValue: Float = response.body()!!.response.body.items.item[0].fcstValue
                println("$codeValue, $fcstValue")
                codeValue = response.body()!!.response.body.items.item[1].category
                fcstValue = response.body()!!.response.body.items.item[1].fcstValue
                println("$codeValue, $fcstValue")

                if (response.isSuccessful){
                    Log.d("api", response.body().toString())
                    Log.d("api", response.body()!!.response.body.items.item.toString())
                    Log.d("api", response.body()!!.response.body.items.item[0].category)
                }
            }
            override fun onFailure(call: Call<WEATHER>, t: Throwable) {
                Log.d("api fail : ", t.toString())
        }
        })

    }
}