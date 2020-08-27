package io.github.nomorecheckshirts.checkloset

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

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

        btn_preference.setOnClickListener {
            val intent = Intent(this, PreferenceActivity::class.java)
            startActivity(intent)

        }

        btn_viewchange.setOnClickListener {
            val intent2 = Intent(this, TestActivity::class.java)
            startActivity(intent2)

        }
    }
}