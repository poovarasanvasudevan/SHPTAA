package in.shpt.networking;

import java.util.List;

import in.shpt.models.language.CommonCategoriesFormat;
import in.shpt.models.products.Product;
import in.shpt.models.products.book.Books;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by poovarasanv on 5/8/16.
 */
public interface APIProvider {

    @GET("index.php?route=api/product/popular")
    Call<List<Product>> getPopularProducts(@Query("limit") int limit);


    @GET("index.php?route=api/product/latest")
    Call<List<Product>> getLatestProducts(@Query("limit") int limit);

    @GET("index.php?route=product/category")
    Call<Books> getDefaultBookList(
            @Query("page") String page,
            @Query("path") String path,
            @Query("sort") String sort,
            @Query("order") String order,
            @Query("webapi") boolean webapi
    );

    @GET("index.php?route=product/category")
    Call<CommonCategoriesFormat> getLanguages(
            @Query("path") String path,
            @Query("webapi") boolean webapi
    );
}
