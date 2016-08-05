package in.shpt.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.AttributeSet;

import org.androidannotations.annotations.EView;

import in.shpt.R;

/**
 * Created by poovarasanv on 4/8/16.
 */

@EView
public class Button extends carbon.widget.Button {


    int color;

    public Button(Context context) {
        super(context);


        setBackgroundColor(getResources().getColor(R.color.colorPrimary));
        setBackgroundTint(getResources().getColor(R.color.colorPrimary));
        setTextColor(Color.WHITE);
    }

    public Button(Context context, AttributeSet attrs) {
        super(context, attrs);


        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.SHPTButton, 0, 0);
        try {
            color = ta.getColor(R.styleable.SHPTButton_shpt_background, getResources().getColor(R.color.colorPrimary));
        } finally {
            ta.recycle();
        }

        setBackgroundColor(color);
        setBackgroundTint(color);
        setTextColor(Color.WHITE);
    }

    public Button(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);

        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.SHPTButton, 0, 0);
        try {
            color = ta.getColor(R.styleable.SHPTButton_shpt_background, getResources().getColor(R.color.colorPrimary));
        } finally {
            ta.recycle();
        }


        setBackgroundColor(color);
        setBackgroundTint(color);
        setTextColor(Color.WHITE);
    }

}
