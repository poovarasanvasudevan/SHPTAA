package in.shpt.adapter;

import android.content.Context;
import android.view.ViewGroup;

import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.RootContext;

import java.util.List;

import in.shpt.base.RecyclerViewAdapterBase;
import in.shpt.base.ViewWrapper;
import in.shpt.models.products.Product;
import in.shpt.widget.ProductItemView;
import in.shpt.widget.ProductItemView_;

/**
 * Created by poovarasanv on 24/8/16.
 */
@EBean
public class ProductListAdapter extends RecyclerViewAdapterBase<Product, ProductItemView> {

    @RootContext
    Context context;

    @Override
    protected ProductItemView onCreateItemView(ViewGroup parent, int viewType) {
        return  ProductItemView_.build(context);
        //return null;
    }

    public void addData(List<Product> products) {
        items.addAll(products);
    }
    @Override
    public void onBindViewHolder(ViewWrapper<ProductItemView> holder, int position) {

        ProductItemView view = holder.getView();
        Product product = items.get(position);

        view.bind(product);
    }
}
