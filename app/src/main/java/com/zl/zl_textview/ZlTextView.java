package com.zl.zl_textview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.support.annotation.Nullable;
import android.text.SpannableStringBuilder;
import android.text.method.LinkMovementMethod;
import android.util.AttributeSet;
import android.widget.TextView;
import android.widget.Toast;

/**
 * @author xiaolong
 * @ClassName ZlTextView
 * @Date 2019/1/8
 **/
@SuppressLint("AppCompatCustomView")
public class ZlTextView extends TextView implements OnReSubmitAndDeleteListener {

    public ZlTextView(Context context) {
        this(context,null);
    }

    public ZlTextView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ZlTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public void setText(CharSequence text, BufferType type) {
        SpannableStringBuilder builder = TextSpan.getBuilder(text)
                .setTextColor(Color.BLUE)
                .append("重新提交")
                .setImageResource(getResources().getDrawable(R.mipmap.delete))
                .setListener(this)
                .build();
        super.setText(builder, type);
    }

    @SuppressLint("ShowToast")
    @Override
    public void reSubmit() {
        Toast.makeText(getContext(),"RESUBMIT SUCCESS",Toast.LENGTH_SHORT);
    }

    @SuppressLint("ShowToast")
    @Override
    public void delete() {
        Toast.makeText(getContext(),"DELETE SUCCESS",Toast.LENGTH_SHORT);
    }
}
