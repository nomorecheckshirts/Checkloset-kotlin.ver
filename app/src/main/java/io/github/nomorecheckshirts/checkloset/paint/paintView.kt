package io.github.nomorecheckshirts.checkloset.paint

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.view.MotionEvent
import android.view.View
import io.github.nomorecheckshirts.checkloset.paint_test.Companion.CIRCLE
import io.github.nomorecheckshirts.checkloset.paint_test.Companion.color
import io.github.nomorecheckshirts.checkloset.paint_test.Companion.LINE
import io.github.nomorecheckshirts.checkloset.paint_test.Companion.SQ
import io.github.nomorecheckshirts.checkloset.paint_test.Companion.curShaper
import io.github.nomorecheckshirts.checkloset.paint_test.Companion.size

class paintView(context: Context) : View(context) {
    var startX = -1
    var startY = -1
    var stopX = -1
    var stopY = -1

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        when (event?.action){
            MotionEvent.ACTION_DOWN -> {
                startX = event.x.toInt()
                startY = event.y.toInt()
            }

            MotionEvent.ACTION_MOVE, MotionEvent.ACTION_UP -> {
                stopX = event.x.toInt()
                stopY = event.y.toInt()

                this.invalidate()
            }
        }

        return true
    }

    override fun onDraw(canvas: Canvas?): Unit {
        super.onDraw(canvas)
        val paint = Paint()

        paint.style = Paint.Style.STROKE
        paint.strokeWidth = size.toFloat()

        if(color == 1) {
            paint.color = Color.RED
        } else if (color == 2) {
            paint.color = Color.BLUE
        } else {
            paint.color = Color.GREEN
        }

        when (curShaper) {
            LINE ->
                canvas?.drawLine(startX.toFloat(), startY.toFloat(), stopX.toFloat(), stopY.toFloat(), paint)

            CIRCLE -> {
                val radius = Math.sqrt(
                    Math.pow(
                        (stopX - startX).toDouble(), 2.0) + Math.pow((stopY-startY).toDouble(), 2.0)
                )
            }

            SQ -> {
                canvas?.drawRect(startX.toFloat(), startY.toFloat(), stopX.toFloat(), stopY.toFloat(), paint)
            }
        }
    }
}