package io.github.nomorecheckshirts.checkloset

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.calendar_view_main.*
import java.text.SimpleDateFormat
import java.util.*

class CalendarViewActivity : AppCompatActivity() {
    var date:Date = Date(System.currentTimeMillis());

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.calendar_view)

        btn_galleryView.setOnClickListener{
            val intent = Intent(this, GalleryViewActivity::class.java)
            startActivity(intent)
            overridePendingTransition(0, 0)
        }

    }

    override fun onResume(){
        super.onResume();
        var curYear:SimpleDateFormat  = SimpleDateFormat("yyyy", Locale.KOREA);
        var curMonth:SimpleDateFormat = SimpleDateFormat("MM", Locale.KOREA);

        var monthString:String = "";
        if(curMonth.format(date) == "01"){
            monthString = "January"
        } else if (curMonth.format(date) == "02"){
            monthString = "February"
        } else if (curMonth.format(date) == "03"){
            monthString = "March"
        } else if (curMonth.format(date) == "04"){
            monthString = "April"
        } else if (curMonth.format(date) == "05"){
            monthString = "May"
        } else if (curMonth.format(date) == "06"){
            monthString = "June"
        } else if (curMonth.format(date) == "07"){
            monthString = "July"
        } else if (curMonth.format(date) == "08"){
            monthString = "August"
        } else if (curMonth.format(date) == "09"){
            monthString = "September"
        } else if (curMonth.format(date) == "10"){
            monthString = "October"
        } else if (curMonth.format(date) == "11"){
            monthString = "November"
        } else if (curMonth.format(date) == "12"){
            monthString = "December"
        }
        tv_month.setText(monthString +  " " +  curYear.format(date));
    }


}