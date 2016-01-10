package com.example.uitest;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;

public class XwEditText extends View {

	/**
	 * 文本
	 */
	private String mTitleText;
	/**
	 * 文本的颜色
	 */
	private int mTitleTextColor;
	/**
	 * 文本的大小
	 */
	private int mTitleTextSize;

	/**
	 * 绘制时控制文本绘制的范围
	 */
	private Rect mBound;
	private Paint mPaint;

	// public XwEditText(Context context) {
	// super(context);
	// // TODO Auto-generated constructor stub
	// }
	//
	// public XwEditText(Context context, AttributeSet attrs) {
	// super(context, attrs);
	// // TODO Auto-generated constructor stub
	// }

	public XwEditText(Context context, AttributeSet attrs) {
		this(context, attrs, 0);
	}

	public XwEditText(Context context) {
		this(context, null);
	}

	public XwEditText(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
		// TODO Auto-generated constructor stub

		TypedArray a = context.getTheme().obtainStyledAttributes(attrs,
				R.styleable.CustomTitleView, defStyleAttr, 0);
		mTitleTextColor = a.getColor(
				R.styleable.CustomTitleView_titleTextColor, Color.BLACK);
		mTitleText = a.getText(R.styleable.CustomTitleView_titleText)
				.toString();
		mTitleTextSize = a.getDimensionPixelSize(
				R.styleable.CustomTitleView_titleTextSize, 16);

		a.recycle();

		/**
		 * 获得绘制文本的宽和高
		 */
//		mPaint = new Paint();
//		mPaint.setTextSize(mTitleTextSize);
//		mBound = new Rect();
//		mPaint.getTextBounds(mTitleText, 0, mTitleText.length(), mBound);
		mPaint = new Paint();  
        mPaint.setTextSize(mTitleTextSize);  
        // mPaint.setColor(mTitleTextColor);  
        mBound = new Rect();  
        mPaint.getTextBounds(mTitleText, 0, mTitleText.length(), mBound);  
	}

	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		// TODO Auto-generated method stub
		super.onMeasure(widthMeasureSpec, heightMeasureSpec);
	}

	@Override
	protected void onDraw(Canvas canvas) {
		// TODO Auto-generated method stub
		// super.onDraw(canvas);

		// mPaint.setColor(Color.YELLOW);
		// canvas.drawRect(0, 0, getMeasuredWidth(), getMeasuredHeight(),
		// mPaint);
		// mPaint.setColor(mTitleTextColor);
		// canvas.drawText(mTitleText, (getWidth() - mBound.width()) / 2,
		// (getHeight() - mBound.height()) / 2, mPaint);

		mPaint.setColor(Color.YELLOW);
		canvas.drawRect(0, 0, getMeasuredWidth(), getMeasuredHeight(), mPaint);

		mPaint.setColor(mTitleTextColor);
		canvas.drawText(mTitleText, getWidth() / 2 - mBound.width() / 2,
				getHeight() / 2 + mBound.height() / 2, mPaint);
		System.out.println("getHeight="+getHeight());
		System.out.println("mBound.height() ="+mBound.height() );
	}

}
