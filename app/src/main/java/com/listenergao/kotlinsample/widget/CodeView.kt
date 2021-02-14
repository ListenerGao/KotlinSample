package com.listenergao.kotlinsample.widget

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.util.TypedValue
import android.view.Gravity
import androidx.appcompat.widget.AppCompatTextView
import androidx.core.content.ContextCompat
import com.listenergao.base.utils.dp2px
import com.listenergao.kotlinsample.R
import java.util.*

class CodeView constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : AppCompatTextView(context, attrs, defStyleAttr) {


    constructor(context: Context) : this(context, null)
    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0)

    private val paint: Paint = Paint()

    private var currentCode: String? = null

    private val codeList = arrayOf(
            "kotlin",
            "android",
            "java",
            "http",
            "https",
            "okhttp",
            "retrofit",
            "tcp/ip"
    )

    init {
        setTextSize(TypedValue.COMPLEX_UNIT_SP, 18f)
        gravity = Gravity.CENTER
        setBackgroundColor(ContextCompat.getColor(context, R.color.colorPrimary))
        setTextColor(Color.WHITE)

        paint.isAntiAlias = true
        paint.style = Paint.Style.STROKE
        paint.color = ContextCompat.getColor(context, R.color.colorAccent)
        paint.strokeWidth = dp2px(6f)

        updateCode()


    }

    fun updateCode() {
        val random = Random().nextInt(codeList.size)
        currentCode = codeList[random]
        text = currentCode
    }

    fun getCurrentCode():String?{
        return currentCode
    }

    override fun onDraw(canvas: Canvas) {
        canvas.drawLine(0f, height.toFloat(), width.toFloat(), 0f, paint)
        super.onDraw(canvas)
    }

}