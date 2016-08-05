package in.shpt.networking;

import java.util.List;

import in.shpt.models.products.Product;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by poovarasanv on 5/8/16.
 */
public interface APIProvider {

    @GET("index.php?route=api/product/popular")
    Call<List<Product>> getPopularProducts(@Query("limit") int limit);
}
