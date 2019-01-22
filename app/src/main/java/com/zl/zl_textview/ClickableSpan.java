package com.zl.zl_textview;

import android.text.TextPaint;
import android.view.View;


/**
 * @author xiaolong
 * @ClassName ClickableSpan
 * @Date 2019/1/14
 **/
public class ClickableSpan extends android.text.style.ClickableSpan {

    private int mColor;

    private OnClickListener mListener;

    public ClickableSpan(int mColor, OnClickListener mListener) {
        this.mColor = mColor;
        this.mListener = mListener;
    }

    @Override
    public void onClick(View widget) {
        mListener.onClick(widget);
    }

    @Override
    public void updateDrawState(TextPaint ds) {
        super.updateDrawState(ds);
        ds.setColor(mColor);
        ds.setUnderlineText(false);
    }
}
