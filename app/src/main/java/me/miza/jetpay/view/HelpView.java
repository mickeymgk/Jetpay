package me.miza.jetpay.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;

import me.miza.jetpay.R;

public class HelpView extends FrameLayout {
    private TextView mHeader;
    private TextView mBody;

    public HelpView(Context context) {
        super(context);
    }

    public HelpView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public HelpView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public HelpView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(context, attrs);
    }

    private void init(Context context,@Nullable AttributeSet attributeSet) {
        LayoutInflater.from(context).inflate(R.layout.help_view,this,true);
        TypedArray attributes = context.obtainStyledAttributes(attributeSet,R.styleable.HelpView);
        mHeader = findViewById(R.id.header);
        mHeader.setText(attributes.getString(R.styleable.HelpView_Header));
        mBody = findViewById(R.id.body);
        mBody.setText(attributes.getString(R.styleable.HelpView_Body));
        attributes.recycle();
    }

}
