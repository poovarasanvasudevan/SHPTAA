package in.shpt.widget;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.util.AttributeSet;
import android.view.View;

import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EViewGroup;
import org.androidannotations.annotations.LongClick;
import org.androidannotations.annotations.ViewById;

import carbon.widget.CardView;
import carbon.widget.ImageView;
import carbon.widget.LinearLayout;
import carbon.widget.TextView;
import in.shpt.R;
import in.shpt.preference.Icons;

/**
 * Created by poovarasanv on 24/8/16.
 */
@EViewGroup(R.layout.book_list)
public class BookItemView extends LinearLayout {

    Context context;

    @ViewById
    TextView bookProductCost;

    @ViewById
    TextView bookProductName;

    @ViewById
    ImageView bookProductImage;

    @ViewById
    CardView bookProductCard;

    @Bean
    Icons icons;

    @ViewById
    TextView freeShippingLabel;

    in.shpt.models.products.book.Product product = null;

    public BookItemView(Context context) {
        super(context);
        this.context = context;
    }

    public BookItemView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
    }

    public BookItemView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;
    }

    public void bind(in.shpt.models.products.book.Product product) {

        bookProductName.setText(product.getName());
        bookProductCost.setText(product.getPrice());
        icons.displayImage(product.getThumb(), bookProductImage);
        if (product.getFreeShippingDate() != null) {

            freeShippingLabel.setVisibility(VISIBLE);
        }
        this.product = product;
    }

    @LongClick(R.id.bookProductCard)
    public void bookLongClikc(View v) {
        final CharSequence[] items = {
                "View Product", "Add to Wishlist", "Add to Cart","Cancel"
        };

        new AlertDialog.Builder(context)
               // .setTitle("Choose Options")
                .setItems(items, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int item) {

                    }
                })
                .show();

    }
}
