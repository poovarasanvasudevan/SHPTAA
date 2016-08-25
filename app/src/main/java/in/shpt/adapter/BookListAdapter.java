package in.shpt.adapter;

import android.content.Context;
import android.view.ViewGroup;

import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.RootContext;

import java.util.List;

import in.shpt.base.RecyclerViewAdapterBase;
import in.shpt.base.ViewWrapper;
import in.shpt.widget.BookItemView;
import in.shpt.widget.BookItemView_;

/**
 * Created by poovarasanv on 24/8/16.
 */
@EBean
public class BookListAdapter extends RecyclerViewAdapterBase<in.shpt.models.products.book.Product, BookItemView> {

    @RootContext
    Context context;

    int count = 0;
    @Override
    protected BookItemView onCreateItemView(ViewGroup parent, int viewType) {
        return BookItemView_.build(context);
        // return null;
    }

    public void addData(List<in.shpt.models.products.book.Product> products) {
        items.addAll(products);
    }

    public void appendData(List<in.shpt.models.products.book.Product> products) {
        items.addAll(products);
        notifyDataSetChanged();
    }

    public void clearData() {
        count = items.size();
        items.clear();
        notifyItemRangeRemoved(0,count);
    }

    @Override
    public void onBindViewHolder(ViewWrapper<BookItemView> holder, int position) {

        BookItemView view = holder.getView();
        in.shpt.models.products.book.Product book = items.get(position);
        book.setThumb("data/" + book.getProductId() + "_FC.jpg");
        view.bind(book);
    }
}
