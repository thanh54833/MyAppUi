package com.example.myapp.aimation

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.util.Log
import android.view.View

class BaseView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    private val paint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        style = Paint.Style.FILL
        textAlign = Paint.Align.CENTER
        textSize = 55.0f
        typeface = Typeface.create("", Typeface.BOLD)

        color = Color.GRAY
    }
    var mMatrix = Matrix()
    var timeStart: Long = System.currentTimeMillis()

    var framesPerSecond = 60
    var animationDuration: Long = 10000 // 10 seconds


    init {
        isClickable = true
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        val elapsedTime = System.currentTimeMillis() - timeStart

        Log.i("===", "=== elapsedTime :== $elapsedTime===$animationDuration")

        matrix.postRotate(130f)//(30 * elapsedTime / 1000).toFloat())
        matrix.postTranslate(200f, 100f)//(100 * elapsedTime / 1000).toFloat(), 0F)

        canvas?.concat(matrix)
        canvas?.drawRect(0f, 100f, 200f, 200f, paint)


        /*if (elapsedTime < animationDuration) {
            this.postInvalidateDelayed((1000 / framesPerSecond).toLong())
        }*/
    }


    override fun performClick(): Boolean {

        paint.color = Color.RED

        invalidate()

        return super.performClick()
    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)


    }

}

