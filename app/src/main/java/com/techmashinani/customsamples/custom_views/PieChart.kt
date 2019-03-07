package com.techmashinani.customsamples.custom_views

import android.content.Context
import android.graphics.BlurMaskFilter
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import com.techmashinani.customsamples.R

class PieChart(context: Context, attrs: AttributeSet) : View(context, attrs) {

    private var mShowText: Boolean
    private var labelPosition: Int
    private var textColor = Color.GREEN
    private var textHeight = 0f
    private var textWidth = 0f

    private val textPaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        color = textColor

        if(textHeight == 0f) {
            textHeight = textSize
        } else {
            textSize = textHeight
        }
    }

    private val piePaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        style = Paint.Style.FILL
        textSize = textHeight
    }

    private val shadowPaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        color = 0x101010
        maskFilter = BlurMaskFilter(8f, BlurMaskFilter.Blur.NORMAL)
    }

    init {
        context.theme.obtainStyledAttributes(attrs, R.styleable.PieChart, 0, 0)
            .apply {
                try {
                    mShowText = getBoolean(R.styleable.PieChart_showText, false)
                    labelPosition = getInteger(R.styleable.PieChart_labelPosition, 0)
                } finally {
                    recycle()
                }
            }
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        // super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        val minWidth: Int = paddingLeft + paddingRight + suggestedMinimumWidth
        val width: Int = View.resolveSizeAndState(minWidth, widthMeasureSpec, 1)

        val minHeight: Int = paddingTop + paddingBottom + View.MeasureSpec.getSize(width) - textWidth.toInt()
        val height: Int = View.resolveSizeAndState(minHeight, heightMeasureSpec, 0)

        setMeasuredDimension(width, height)
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        canvas.drawCircle(0f, 0f, 30f, piePaint)
    }

    fun isShowText(): Boolean = mShowText
    fun setShowText(showText: Boolean) {
        mShowText = showText
        invalidate()
        requestLayout()
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        return super.onTouchEvent(event)
    }

}