package in.shpt.widget;

import android.content.Context;
import android.content.DialogInterface;
import android.os.AsyncTask;
import android.support.v7.app.AlertDialog;
import android.text.Html;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

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
import in.shpt.event.WishListEvent;
import in.shpt.networking.CartWorker;
import in.shpt.networking.WishListWorker;
import in.shpt.preference.Icons;

/**
 * Created by poovarasanv on 24/8/16.
 */
@EViewGroup(R.layout.wish_list)
public class WishListItemView extends LinearLayout {

    Context context;


    @ViewById
    TextView wbookProductCost;

    @ViewById
    TextView wbookProductName;

    @ViewById
    ImageView wbookProductImage;

    @ViewById
    CardView wbookProductCard;

    @Bean
    Icons icons;

    @Bean
    CartWorker cartWorker;

    @Bean
    WishListWorker wishListWorker;

    @ViewById
    TextView freeShippingLabel;

    JSONObject product;

    public WishListItemView(Context context) {
        super(context);
        this.context = context;
    }

    public WishListItemView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
    }

    public WishListItemView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;
    }

    public void bind(JSONObject product) {


        wbookProductName.setText(Html.fromHtml(product.optString("name")));
        wbookProductCost.setText(product.optString("price"));
        icons.displayImage(product.optString("thumb"), wbookProductImage);
        this.product = product;
    }

    @LongClick(R.id.wbookProductCard)
    public void bookLongClikc(View v) {
        final CharSequence[] items = {
                "View Product", "Add to Cart", "Remove from Wishlist", "Cancel"
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
                                new AddToCartTask().execute();
                            }
                            break;
                            case 2: {
                                new RemoveWishList().execute();
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

    class AddToCartTask extends AsyncTask<String, Void, JSONObject> {
        @Override
        protected JSONObject doInBackground(String... voids) {
            try {
                Log.i("Cart Total", "Rnning");
                return cartWorker.addToCart(product.optString("product_id"), 1);
            } catch (IOException e) {
                e.printStackTrace();
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(JSONObject jsonObject) {
            Log.i("Cart Total", jsonObject.optString("total"));

            if (jsonObject != null) {

                Log.i("Cart Total", jsonObject.optString("total"));
                EventBus.getDefault().post(new CartEvent(
                        Html.fromHtml(jsonObject.optString("success")).toString(),
                        jsonObject.optString("total").replace("(", "").replace(")", "")
                ));
            }
            super.onPostExecute(jsonObject);
        }
    }

    class RemoveWishList extends AsyncTask<Void, Void, JSONObject> {
        @Override
        protected JSONObject doInBackground(Void... voids) {

            try {
                return wishListWorker.removeWishList(product.optString("product_id"));
            } catch (IOException e) {
                e.printStackTrace();
            } catch (JSONException e) {
                e.printStackTrace();
            }

            return null;
        }

        @Override
        protected void onPostExecute(JSONObject jsonObject) {

            EventBus.getDefault().post(new WishListEvent(
                    "refresh",
                    "0"
            ));
            super.onPostExecute(jsonObject);
        }
    }
}
