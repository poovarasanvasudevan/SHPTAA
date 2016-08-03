package in.shpt.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.EditText;

import org.androidannotations.annotations.EView;

import in.shpt.R;

/**
 * Created by poovarasanv on 3/8/16.
 */

@EView
public class PlainEditText extends EditText {

    public PlainEditText(Context context) {
        super(context);
        setBackgroundResource(R.drawable.square_hollow_bg_gray);
        setTextSize(22f);
    }

    public PlainEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        setBackgroundResource(R.drawable.square_hollow_bg_gray);
        setTextSize(22f);
    }

    public PlainEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setBackgroundResource(R.drawable.square_hollow_bg_gray);
        setTextSize(22f);
    }
}
