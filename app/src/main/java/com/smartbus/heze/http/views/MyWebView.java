package com.smartbus.heze.http.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.webkit.WebView;

/**
 * Created by Administrator on 2019/8/16.
 */

public class MyWebView extends WebView {

    private OnTouchEventCallback mOnTouchEventCallback;

    public MyWebView(Context context) {
        super(context);
    }

    public MyWebView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyWebView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                if (mOnTouchEventCallback!=null){
                    mOnTouchEventCallback.onActionDown();
                }
                break;
            case MotionEvent.ACTION_MOVE:
                if (mOnTouchEventCallback!=null){
                    mOnTouchEventCallback.onActionMove();
                }
                break;
        }
        return super.onTouchEvent(event);
    }

    public OnTouchEventCallback getOnTouchEventCallback() {
        return mOnTouchEventCallback;
    }

    public void setOnTouchEventCallback(
            final OnTouchEventCallback onTouchEventCallback) {
        mOnTouchEventCallback = onTouchEventCallback;
    }

    public static interface OnTouchEventCallback {
        public void onActionDown();
        public void onActionMove();
    }
}
