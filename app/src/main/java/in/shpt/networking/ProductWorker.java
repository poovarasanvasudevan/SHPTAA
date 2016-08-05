package in.shpt.networking;

import android.content.Context;

import org.androidannotations.annotations.App;
import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.RootContext;

import java.io.IOException;
import java.util.List;

import in.shpt.application.SHPT;
import in.shpt.models.products.Product;

/**
 * Created by poovarasanv on 5/8/16.
 */

@EBean
public class ProductWorker {

    @RootContext
    Context context;

    @App
    SHPT shpt;


    public List<Product> getPopularProducts(int limit) throws IOException {
        return shpt
                .getAdapter()
                .getPopularProducts(limit)
                .execute()
                .body();
    }
}
