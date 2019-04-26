package com.smartbus.heze.http.views;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by Administrator on 2018/4/25 0018.
 * 跑马灯
 */

public class ScrollForeverTextView extends TextView {
    public ScrollForeverTextView(Context context) {
        super(context);
    }

    public ScrollForeverTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ScrollForeverTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }
    @Override
    public boolean isFocused() {
        return true;
    }
}
