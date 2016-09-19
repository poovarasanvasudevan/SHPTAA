package in.shpt.adapter;

import android.content.Context;
import android.view.ViewGroup;

import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.RootContext;
import org.json.JSONObject;

import java.util.List;

import in.shpt.base.RecyclerViewAdapterBase;
import in.shpt.base.ViewWrapper;
import in.shpt.widget.CartItemView;
import in.shpt.widget.CartItemView_;

/**
 * Created by poovarasanv on 24/8/16.
 */
@EBean
public class CartAdapter extends RecyclerViewAdapterBase<JSONObject, CartItemView> {

    @RootContext
    Context context;

    int count = 0;

    @Override
    protected CartItemView onCreateItemView(ViewGroup parent, int viewType) {
        return CartItemView_.build(context);
        // return null;
    }

    public void addData(List<JSONObject> products) {
        items.addAll(products);
    }

    public void appendData(List<JSONObject> products) {
        items.addAll(products);
        notifyDataSetChanged();
    }

    public void clearData() {
        count = items.size();
        items.clear();
        notifyItemRangeRemoved(0, count);
    }



    @Override
    public void onBindViewHolder(ViewWrapper<CartItemView> holder, int position) {
        CartItemView view = holder.getView();
        JSONObject wish = items.get(position);
        view.bind(wish);
    }
}
