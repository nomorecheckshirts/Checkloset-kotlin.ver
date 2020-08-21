package io.github.nomorecheckshirts.checkloset

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import io.github.nomorecheckshirts.checkloset.db.DBHelper
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    internal lateinit var db:DBHelper
    var responseDB="no good"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        db= DBHelper(this)

        val printresult = findViewById(R.id.hellowr) as EditText
        printresult.setText(responseDB)

    }
}