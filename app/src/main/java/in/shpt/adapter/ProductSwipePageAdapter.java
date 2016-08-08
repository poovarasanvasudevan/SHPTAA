package in.shpt.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

import in.shpt.fragment.ProductCardFragment;
import in.shpt.models.products.Product;

/**
 * Created by poovarasanv on 8/8/16.
 */
public class ProductSwipePageAdapter extends FragmentPagerAdapter {

    List<Product> products;

    public ProductSwipePageAdapter(FragmentManager fm) {
        super(fm);
    }

    public ProductSwipePageAdapter(FragmentManager fm, List<Product> products) {
        super(fm);
        this.products = products;
    }


    @Override
    public Fragment getItem(int position) {
        return ProductCardFragment.newInstance(products.get(position));
    }

    @Override
    public int getCount() {
        return products.size();
    }
}
