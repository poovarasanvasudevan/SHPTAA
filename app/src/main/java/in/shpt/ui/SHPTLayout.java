package in.shpt.ui;

import android.content.Context;
import android.util.AttributeSet;

import com.parse.ConfigCallback;
import com.parse.ParseConfig;
import com.parse.ParseException;

import org.androidannotations.annotations.EViewGroup;
import org.androidannotations.annotations.ViewById;

import carbon.widget.RelativeLayout;
import in.shpt.R;
import in.shpt.config.Config;
import in.shpt.shptenum.AlertMakerEnum;

/**
 * Created by poovarasanv on 8/9/16.
 */
@EViewGroup(R.layout.shpt_layout)
public class SHPTLayout extends RelativeLayout {

    @ViewById
    AlertMaker alertMaker;

    public SHPTLayout(Context context) {
        super(context);
        verifyCouponNotification();
    }

    public SHPTLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        verifyCouponNotification();
    }

    public SHPTLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        verifyCouponNotification();
    }


    public void verifyCouponNotification() {
        ParseConfig.getInBackground(new ConfigCallback() {
            @Override
            public void done(ParseConfig config, ParseException e) {

                if (config != null) {
                    String coupon_discount = config.getString(Config.DISCOUNT_MESSAGE, null);
                    if (coupon_discount != null) {
                        alertMaker.makeAlert(coupon_discount, AlertMakerEnum.FAILURE, true);
                    }
                }

            }
        });

    }
}
