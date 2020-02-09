package com.listenergao.kotlinsimple.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.Gravity;


import java.util.Random;

import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatTextView;

import com.listenergao.base.utils.Utils;
import com.listenergao.kotlinsimple.R;

public class CodeView extends AppCompatTextView {

    public CodeView(Context context) {
        this(context, null);
    }

    public CodeView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        setTextSize(TypedValue.COMPLEX_UNIT_SP, 18f);
        setGravity(Gravity.CENTER);
        setBackgroundColor(getContext().getResources().getColor(R.color.colorPrimary));
        setTextColor(Color.WHITE);

        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(getContext().getResources().getColor(R.color.colorAccent));
        paint.setStrokeWidth(Utils.dp2px(6f));

        updateCode();
    }

    private Paint paint = new Paint();

    private String[] codeList = new String[]{
            "kotlin",
            "android",
            "java",
            "http",
            "https",
            "okhttp",
            "retrofit",
            "tcp/ip"
    };


    public void updateCode() {
        final int random = new Random().nextInt(codeList.length);
        final String code = codeList[random];
        setText(code);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawLine(0f, getHeight(), getWidth(), 0f, paint);
        super.onDraw(canvas);
    }
}
