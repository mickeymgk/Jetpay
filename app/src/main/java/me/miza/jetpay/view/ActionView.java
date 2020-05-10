package me.miza.jetpay.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import me.miza.jetpay.R;

public class ActionView extends FrameLayout {
    private AppCompatTextView mTextView;
    private AppCompatImageView mImageView;
    private View mDivider;

    public ActionView(Context context) {
        super(context);
    }

    public ActionView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public ActionView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public ActionView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(context, attrs);
    }

    private void init(Context context,@Nullable AttributeSet attributeSet) {
        LayoutInflater.from(context).inflate(R.layout.action_view,this,true);
        TypedArray attributes = context.obtainStyledAttributes(attributeSet,R.styleable.ActionView);
        mTextView = findViewById(R.id.text_action);
        mTextView.setText(attributes.getString(R.styleable.ActionView_ActionText));
        mImageView = findViewById(R.id.icon_action);
        mImageView.setImageDrawable(attributes.getDrawable(R.styleable.ActionView_ActionIcon));
        mDivider = findViewById(R.id.divider);
        mDivider.setVisibility(attributes.getInt(R.styleable.ActionView_ActionDivider,VISIBLE));
        attributes.recycle();
    }

    public void setText(String text) {
        mTextView.setText(text);
    }

    public void setIconColor(int color) {
        mImageView.setColorFilter(color);
    }

    public void setTextColor(int color) {
        mTextView.setTextColor(color);
        mImageView.setColorFilter(color);
    }

}
