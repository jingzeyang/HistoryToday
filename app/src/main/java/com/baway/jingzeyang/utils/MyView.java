package com.baway.jingzeyang.utils;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;

import com.baway.jingzeyang.R;

/**
 * 作者： 荆泽阳
 * * 时间： 2017/3/17 12:23
 * * 描述： 尚未编写描述
 */

public class MyView extends View{

    private int mRadius;
    private Paint mpaint;
    private Paint mstrokePaint;
    private Paint mDotLinePaint;

    public MyView(Context context) {
        this(context,null);
        init();
    }

    public MyView(Context context, AttributeSet attrs) {
        this(context, attrs, R.style.AppTheme);
        init();
    }

    public MyView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        mpaint = new Paint();
        mpaint.setColor(Color.RED);
        mpaint.setAntiAlias(true);

        mstrokePaint = new Paint();
        mstrokePaint.setAntiAlias(true);
        mstrokePaint.setColor(Color.RED);
        mstrokePaint.setStrokeWidth(3);
        mstrokePaint.setStyle(Paint.Style.STROKE);

        mDotLinePaint = new Paint();
        mDotLinePaint.setAntiAlias(true);
        mDotLinePaint.setColor(Color.RED);
        mDotLinePaint.setStyle(Paint.Style.STROKE);
        mDotLinePaint.setStrokeWidth(4);

        //绘制线
        mDotLinePaint.setPathEffect(new DashPathEffect(new float[]{5,4},0));
        mRadius = DanweiUtil.dp2px(getContext(),6);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        int widthMode=MeasureSpec.getMode(widthMeasureSpec);
        int widthSize=MeasureSpec.getSize(widthMeasureSpec);
        int heightMode=MeasureSpec.getMode(heightMeasureSpec);
        int heightSize=MeasureSpec.getSize(heightMeasureSpec);
        //未指定模式
        if (widthMode == MeasureSpec.UNSPECIFIED){
            widthSize = DanweiUtil.dp2px(getContext(),20);
        }
        if (heightMode == MeasureSpec.UNSPECIFIED){
            heightSize = DanweiUtil.dp2px(getContext(),20);
        }
        setMeasuredDimension(widthSize,heightSize);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawLine(getWidth()/2,0,getWidth()/2,getHeight()/5,mstrokePaint);
        canvas.drawCircle(getWidth()/2,getHeight()/5+mRadius,mRadius*2/3,mpaint);
        Path path=new Path();
        path.moveTo(getWidth()/2+mRadius+DanweiUtil.dp2px(getContext(),3),getHeight()/5+mRadius);
        path.lineTo(getWidth(),getHeight()/5+mRadius);
        canvas.drawPath(path,mDotLinePaint);
        canvas.drawCircle(getWidth()/2,getHeight()/5+mRadius,mRadius,mstrokePaint);
        canvas.drawLine(getWidth()/2,getHeight()/5+2*mRadius,getWidth()/2,getHeight(),mstrokePaint);
    }
}
