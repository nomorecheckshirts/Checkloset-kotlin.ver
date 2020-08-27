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
import retrofit2.http.GET
import retrofit2.http.Query

val num_of_rows: Int = 10
val page_no: Int = 1
val data_type: String = "JSON"
val base_time: String = "0500"
val base_date: String = "20200827"
val nx: Int = 59
val ny: Int = 125

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

        val call = ApiObject.retrofitService.GetWeather(data_type, num_of_rows, page_no, base_date, base_time, nx, ny)
        call.enqueue(object : retrofit2.Callback<WEATHER>{
            override fun onResponse(call: Call<WEATHER>, response: Response<WEATHER>) {
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

        val jsonString = """
        {
            "response":{
                "header":{"resultCode":"00","resultMsg":"NORMAL_SERVICE"},
                "body":{
                    "dataType":"JSON","items":{
                        "item":[
                        {"baseDate":"20200826","baseTime":"2000","category":"POP","fcstDate":"20200827","fcstTime":"0000","fcstValue":"80","nx":59,"ny":125},
                        {"baseDate":"20200826","baseTime":"2000","category":"PTY","fcstDate":"20200827","fcstTime":"0000","fcstValue":"1","nx":59,"ny":125},
                        {"baseDate":"20200826","baseTime":"2000","category":"R06","fcstDate":"20200827","fcstTime":"0000","fcstValue":"10","nx":59,"ny":125},
                        {"baseDate":"20200826","baseTime":"2000","category":"REH","fcstDate":"20200827","fcstTime":"0000","fcstValue":"75","nx":59,"ny":125},
                        {"baseDate":"20200826","baseTime":"2000","category":"S06","fcstDate":"20200827","fcstTime":"0000","fcstValue":"0","nx":59,"ny":125},
                        {"baseDate":"20200826","baseTime":"2000","category":"SKY","fcstDate":"20200827","fcstTime":"0000","fcstValue":"4","nx":59,"ny":125},
                        {"baseDate":"20200826","baseTime":"2000","category":"T3H","fcstDate":"20200827","fcstTime":"0000","fcstValue":"28","nx":59,"ny":125},
                        {"baseDate":"20200826","baseTime":"2000","category":"UUU","fcstDate":"20200827","fcstTime":"0000","fcstValue":"-11.7","nx":59,"ny":125},   
                        {"baseDate":"20200826","baseTime":"2000","category":"VEC","fcstDate":"20200827","fcstTime":"0000","fcstValue":"139","nx":59,"ny":125},
                        {"baseDate":"20200826","baseTime":"2000","category":"VVV","fcstDate":"20200827","fcstTime":"0000","fcstValue":"13.7","nx":59,"ny":125},
                        {"baseDate":"20200826","baseTime":"2000","category":"WSD","fcstDate":"20200827","fcstTime":"0000","fcstValue":"18.1","nx":59,"ny":125}
                        ]
                    },
                "pageNo":1,"numOfRows":11,"totalCount":175
                }
            }
        }
        """.trimIndent()
    }
}