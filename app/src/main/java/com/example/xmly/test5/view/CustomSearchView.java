package com.example.xmly.test5.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.AccelerateInterpolator;


public class CustomSearchView extends View {

    private Paint mPaint;
    private float mRectX = 10;
    private float mRectY = 10;
    private float mLengh = 500;
    private static final String TAG = "CustomSearchView";
    private int mDuration = 400;
    public boolean mIsClose;

    public CustomSearchView(Context context) {
        super(context);
        init(context);
    }

    public CustomSearchView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public CustomSearchView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {
        mPaint = new Paint();
        mPaint.setColor(Color.parseColor("#272729"));
        mPaint.setStrokeWidth(2);
        mPaint.setAntiAlias(true);
        mPaint.setStyle(Paint.Style.STROKE);
        mLengh = mLengh * getDesity();
        mRectX = mRectX * getDesity();
        mRectY = mRectY * getDesity();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawRoundRect(0, 0, mLengh, 100 * getDesity(), mRectX, mRectY, mPaint);
    }

    public void startSearckAnimator(final OnAnimatorEndListener onAnimatorEndListener) {
        if (!mIsClose){
            return;
        }
        final ValueAnimator animator = ValueAnimator.ofFloat(0.2f, 1f);
        animator.setDuration(mDuration);
        animator.start();
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                mLengh = (float) animator.getAnimatedValue() * 500 * getDesity(); //(500,100)
                mRectX = (1.2f - (float) animator.getAnimatedValue()) * 50 * getDesity();
                mRectY = (1.2f - (float) animator.getAnimatedValue()) * 50 * getDesity(); //(10,50)
                if (mLengh > 300 * getDesity()) {
                    //setHint("请输入搜索内容");
                }
                invalidate();
                //Log.i(TAG, "onAnimationUpdate: "+mLengh +"      "+mRectX+"  "+mRectY);
            }
        });
        animator.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                onAnimatorEndListener.end();
                mIsClose = false;
            }
        });

    }

    public void closeSearckAnimator() {
        mIsClose = true;
        //setHint("");
        final ValueAnimator animator = ValueAnimator.ofFloat(1, 0.2f);
        animator.setInterpolator(new AccelerateInterpolator());
        animator.setDuration(mDuration);
        animator.start();
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                mLengh = (float) animator.getAnimatedValue() * 500 * getDesity(); //(500,100)
                mRectX = (1.2f - (float) animator.getAnimatedValue()) * 50 * getDesity();
                mRectY = (1.2f - (float) animator.getAnimatedValue()) * 50 * getDesity(); //(10,50)
                invalidate();
                //Log.i(TAG, "onAnimationUpdate: "+mLengh +"      "+mRectX+"  "+mRectY);
            }
        });

    }

    public float getDesity() {

        DisplayMetrics dm = new DisplayMetrics();
        dm = getResources().getDisplayMetrics();
        return dm.density;        // 屏幕
    }
    public interface OnAnimatorEndListener{
        void end();
    }

}
