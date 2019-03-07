package com.techmashinani.customsamples.custom_views

import android.content.Context
import android.os.Build
import android.util.AttributeSet
import android.view.View
import androidx.annotation.RequiresApi
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Rect


class MyCustomView : View {

    private val paint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        color = Color.MAGENTA
    }

    private val rect = Rect()

    constructor(context: Context) : super(context) {
        init(null)
    }

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
        init(attrs)
    }

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        init(attrs)
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int, defStyleRes: Int) : super(
        context,
        attrs,
        defStyleAttr,
        defStyleRes
    ) {
        init(attrs)
    }

    private fun init(set: AttributeSet?) {
        // set attributes
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        canvas.apply {
            rect.left = 0
            rect.right = width
            rect.top = 0
            rect.bottom = height
            drawRect(rect, paint)
        }
    }
}