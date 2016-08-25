package in.shpt.base;

import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by poovarasanv on 24/8/16.
 */
public class ViewWrapper<V extends View> extends RecyclerView.ViewHolder {

    private V view;

    public ViewWrapper(V itemView) {
        super(itemView);
        view = itemView;
    }

    public V getView() {
        return view;
    }
}