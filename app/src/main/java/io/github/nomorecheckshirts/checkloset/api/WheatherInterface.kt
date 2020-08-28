package io.github.nomorecheckshirts.checkloset.api

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

data class WEATHER (
    val response : RESPONSE
)
data class RESPONSE (
    val header : HEADER,
    val body : BODY
)
data class HEADER(
    val resultCode : Int,
    val resultMsg : String
)
data class BODY(
    val dataType : String,
    val items : ITEMS
)
data class ITEMS(
    val item : List<ITEM>
)
data class ITEM(
    val baseDate : String,
    val baseTime : Int,
    val category : String,
    var fcstValue : Float
)

interface WeatherInterface {
    @GET("getVilageFcst?serviceKey=TRwdruH8UvmPRNLZVWveBqi0YWCHAgkV0jr0U7wWh6oLzX75ud4qSCRqgIJopjyJHCExGAersroliUTpmRqscA%3D%3D")
    fun GetWeather(
        @Query("dataType") data_type : String,
        @Query("numOfRows") num_of_rows : Int,
        @Query("pageNo") page_no : Int,
        @Query("base_date") base_date : String,
        @Query("base_time") base_time : String,
        @Query("nx") nx : Int,
        @Query("ny") ny : Int
    ): Call<WEATHER>
}