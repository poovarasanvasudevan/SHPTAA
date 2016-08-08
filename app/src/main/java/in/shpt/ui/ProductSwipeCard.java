package in.shpt.ui;

import android.content.Context;
import android.support.v4.app.FragmentManager;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

import org.androidannotations.annotations.EViewGroup;
import org.androidannotations.annotations.ViewById;

import java.util.List;

import in.shpt.R;
import in.shpt.adapter.ProductSwipePageAdapter;
import in.shpt.models.products.Product;
import me.relex.circleindicator.CircleIndicator;

/**
 * Created by poovarasanv on 8/8/16.
 */
@EViewGroup(R.layout.swipe_card)
public class ProductSwipeCard extends RelativeLayout {

    @ViewById
    android.support.v4.view.ViewPager productViewPager;

    @ViewById
    CircleIndicator indicator;


    public ProductSwipeCard(Context context) {
        super(context);
    }


    public ProductSwipeCard(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ProductSwipeCard(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    public void setUpPager(FragmentManager manager, List<Product> products) {
        ProductSwipePageAdapter productSwipePageAdapter = new ProductSwipePageAdapter(manager, products);
        productViewPager.setAdapter(productSwipePageAdapter);
        productSwipePageAdapter.notifyDataSetChanged();
        indicator.setViewPager(productViewPager);
    }

}
