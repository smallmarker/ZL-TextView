package com.zl.zl_textview;

import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.ImageSpan;
import android.view.View;

/**
 * @author xiaolong
 * @ClassName TextSpan
 * @Date 2019/1/14
 **/
public class TextSpan {

    private int mColor;

    private Drawable mDrawable;

    private CharSequence mContent;

    public static Builder getBuilder(CharSequence mContent) {
        return new Builder(mContent);
    }

    public static class Builder {

        private OnReSubmitAndDeleteListener mListener;

        private SpannableStringBuilder mBuilder;

        private TextSpan mTextSpan;

        public Builder setListener(OnReSubmitAndDeleteListener mListener) {
            this.mListener = mListener;
            return this;
        }

        public Builder(CharSequence mContent) {
            mBuilder = new SpannableStringBuilder(mContent);
            mTextSpan = new TextSpan();
        }

        public Builder append(CharSequence mContext) {
            mTextSpan.mContent = mContext;
            setTextSpan();
            return this;
        }

        public Builder setTextColor(int mColor) {
            mTextSpan.mColor = mColor;
            return this;
        }

        public Builder setImageResource(Drawable mDrawable) {
            mTextSpan.mDrawable = mDrawable;
            setImageSpan();
            return this;
        }

        public SpannableStringBuilder build() {
            return mBuilder;
        }


        private void setImageSpan() {
            mBuilder.append("   ");
            int start = mBuilder.length();
            mBuilder.append("\uFFFC");
            int end = mBuilder.length();
            mTextSpan.mDrawable.setBounds(0,0,mTextSpan.mDrawable.getIntrinsicWidth(),mTextSpan.mDrawable.getIntrinsicHeight());
            ImageSpan imageSpan = new ImageSpan(mTextSpan.mDrawable,ImageSpan.ALIGN_BASELINE);
            mBuilder.setSpan(imageSpan,start,end,Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            mBuilder.setSpan(new android.text.style.ClickableSpan() {
                @Override
                public void onClick(View widget) {
                    if (mListener != null) {
                        mListener.delete();
                    }
                }
            }, start, end, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        }

        private void setTextSpan() {
            mBuilder.append("   ");
            int start = mBuilder.length();
            mBuilder.append(mTextSpan.mContent);
            int end = mBuilder.length();
            mBuilder.setSpan(new ClickableSpan(mTextSpan.mColor, new OnClickListener() {
                @Override
                public void onClick(View widget) {
                    if (mListener != null) {
                        mListener.reSubmit();
                    }
                }
            }), start, end, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        }
    }

}
