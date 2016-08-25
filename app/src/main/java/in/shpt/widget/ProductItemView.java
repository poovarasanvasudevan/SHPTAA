package in.shpt.widget;

import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.View;

import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EViewGroup;
import org.androidannotations.annotations.ViewById;

import carbon.widget.CardView;
import carbon.widget.ImageView;
import carbon.widget.LinearLayout;
import carbon.widget.TextView;
import in.shpt.R;
import in.shpt.activity.FullProductActivity_;
import in.shpt.models.products.Product;
import in.shpt.preference.Icons;

/**
 * Created by poovarasanv on 24/8/16.
 */
@EViewGroup(R.layout.product_list)
public class ProductItemView extends LinearLayout {

    Context context;

    @ViewById
    TextView popularProductCost;

    @ViewById
    TextView popularProductName;

    @ViewById
    ImageView popularProductImage;

    @ViewById
    CardView popularProductCard;

    @Bean
    Icons icons;

    Product product = null;

    public ProductItemView(Context context) {
        super(context);
        this.context =context;
    }

    public ProductItemView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context =context;
    }

    public ProductItemView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context =context;
    }

    public void bind(Product product) {

        popularProductName.setText(product.getName());
        popularProductCost.setText(product.getPrice());
        icons.displayImage(product.getImage(),popularProductImage);

        this.product = product;
    }

    @Click(R.id.popularProductCard)
    public void popularProductClick(View v) {
        FullProductActivity_.intent(context)
                .product(product)
                .flags(Intent.FLAG_ACTIVITY_NEW_TASK)
                .start();
    }

}
