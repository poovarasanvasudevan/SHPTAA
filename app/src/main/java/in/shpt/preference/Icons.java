package in.shpt.preference;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;

import com.mikepenz.iconics.IconicsDrawable;
import com.mikepenz.ionicons_typeface_library.Ionicons;
import com.squareup.picasso.Picasso;

import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.RootContext;

import carbon.widget.ImageView;

/**
 * Created by poovarasanv on 8/8/16.
 */
@EBean
public class Icons {

    @RootContext
    Context context;

    public Drawable getIcon(Ionicons.Icon icon) {
        return new IconicsDrawable(context)
                .icon(icon)
                .color(Color.WHITE)
                .sizeDp(20);
    }

    public Drawable getIcon(Ionicons.Icon icon, int size, int color) {
        return new IconicsDrawable(context)
                .icon(icon)
                .color(color)
                .sizeDp(size);
    }

    public Drawable getIcon(String icon) {
        return new IconicsDrawable(context)
                .icon(icon)
                .color(Color.DKGRAY)
                .sizeDp(10);
    }


    public void displayImage(String url, ImageView imageView) {

        if (url != null) {

            Picasso.with(context)
                    .load("http://10.0.2.2:8080/image/" + url)
                    .resize(220, 300)
                    .into(imageView);
        }
    }
}
