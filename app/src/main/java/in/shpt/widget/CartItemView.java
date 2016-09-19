package in.shpt.widget;

import android.content.Context;
import android.content.DialogInterface;
import android.os.AsyncTask;
import android.support.v7.app.AlertDialog;
import android.text.Html;
import android.util.AttributeSet;
import android.view.View;

import com.squareup.picasso.Picasso;

import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EViewGroup;
import org.androidannotations.annotations.LongClick;
import org.androidannotations.annotations.ViewById;
import org.greenrobot.eventbus.EventBus;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import carbon.widget.CardView;
import carbon.widget.ImageView;
import carbon.widget.LinearLayout;
import carbon.widget.TextView;
import in.shpt.R;
import in.shpt.event.CartEvent;
import in.shpt.networking.CartWorker;
import in.shpt.preference.Icons;

/**
 * Created by poovarasanv on 24/8/16.
 */
@EViewGroup(R.layout.cart_list)
public class CartItemView extends LinearLayout {

    Context context;


    @ViewById
    TextView ccName;

    @ViewById
    TextView ccQty;

    @ViewById
    TextView ccAmount;

    @ViewById
    ImageView ccImage;

    @ViewById
    CardView cccard;

    @Bean
    Icons icons;

    @Bean
    CartWorker cartWorker;

    @ViewById
    TextView freeShippingLabel;

    JSONObject product;

    public CartItemView(Context context) {
        super(context);
        this.context = context;
    }

    public CartItemView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
    }

    public CartItemView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;
    }

    public void bind(JSONObject product) {


        ccName.setText(Html.fromHtml(product.optString("name")));
        ccQty.setText(product.optString("quantity"));
        ccAmount.setText(product.optString("total"));

        String image = product.optString("thumb").replace("localhost", "10.0.2.2");
        Picasso.with(getContext())
                .load(image)
                .into(ccImage);

        //  icons.displayImage(product.optString("thumb"), ccImage);
        this.product = product;
    }

    @LongClick(R.id.cccard)
    public void bookLongClikc(View v) {
        final CharSequence[] items = {
                "View Product", "Remove from Cart", "Edit", "Cancel"
        };

        new AlertDialog.Builder(context)
                // .setTitle("Choose Options")
                .setItems(items, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int item) {
                        switch (item) {
                            case 0: {

                            }
                            break;
                            case 1: {
                                new RemoveFromCart().execute();
                            }
                            break;
                            case 2: {

                            }
                            break;
                            case 3: {
                                dialog.dismiss();
                            }
                            break;
                        }
                    }
                })
                .show();

    }


    class RemoveFromCart extends AsyncTask<Void, Void, Void> {
        @Override
        protected Void doInBackground(Void... voids) {

            try {
                cartWorker.removeFromCart(product.optString("key"));
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            } catch (JSONException e) {
                e.printStackTrace();
                return null;
            }

            return null;
        }

        @Override
        protected void onPostExecute(Void jsonObject) {

            EventBus.getDefault().post(new CartEvent(
                    "refresh",
                    "0"
            ));
            super.onPostExecute(jsonObject);
        }
    }


}
