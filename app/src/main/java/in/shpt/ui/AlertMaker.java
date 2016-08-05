package in.shpt.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

import com.mikepenz.iconics.view.IconicsImageView;
import com.mikepenz.ionicons_typeface_library.Ionicons;

import org.androidannotations.annotations.EViewGroup;
import org.androidannotations.annotations.ViewById;

import carbon.widget.RelativeLayout;
import carbon.widget.TextView;
import in.shpt.R;
import in.shpt.shptenum.AlertMakerEnum;

/**
 * Created by poovarasanv on 5/8/16.
 */

@EViewGroup(R.layout.alert_maker)
public class AlertMaker extends RelativeLayout {

    @ViewById
    RelativeLayout fullLayout;

    @ViewById
    IconicsImageView image;

    @ViewById
    TextView title;

    public AlertMaker(Context context) {
        super(context);
        setVisibility(View.GONE);
    }

    public AlertMaker(Context context, AttributeSet attrs) {
        super(context, attrs);
        setVisibility(View.GONE);
    }

    public AlertMaker(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setVisibility(View.GONE);
    }


    public void makeAlert(String alertText, AlertMakerEnum alertMaker) {
        makeAlert(alertText, alertMaker, 5000);
    }

    public void makeAlert(String alertText, AlertMakerEnum alertMakerEnum, long time) {
        switch (alertMakerEnum) {
            case SUCCESS: {
                image.setIcon(Ionicons.Icon.ion_ios_checkmark_empty);
                fullLayout.setBackgroundColor(getResources().getColor(R.color.md_green_500));
                break;
            }
            case FAILURE: {
                image.setIcon(Ionicons.Icon.ion_ios_close_outline);
                fullLayout.setBackgroundColor(getResources().getColor(R.color.md_red_500));
                break;
            }
            case WARNING: {
                image.setIcon(Ionicons.Icon.ion_android_warning);
                fullLayout.setBackgroundColor(getResources().getColor(R.color.md_orange_400));
                break;
            }
            case INFO: {
                image.setIcon(Ionicons.Icon.ion_ios_information);
                fullLayout.setBackgroundColor(getResources().getColor(R.color.md_blue_200));
                break;
            }
        }
        title.setText(alertText);
        setVisibility(View.VISIBLE);
        new android.os.Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                setVisibility(View.GONE);
            }
        }, time);
    }
}
