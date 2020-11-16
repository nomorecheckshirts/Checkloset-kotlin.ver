package io.github.nomorecheckshirts.checkloset

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import io.github.nomorecheckshirts.checkloset.paint.paintView

class paint_test : AppCompatActivity() {
    companion object {
        var size = 5
        var color = 1
        var LINE = 1
        var curShaper = LINE
        var CIRCLE = 2
        var SQ = 3
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(paintView(this))
    }
}