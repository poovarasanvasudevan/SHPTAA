package in.shpt.networking;

import java.util.List;

import in.shpt.models.language.CommonCategoryFormat;
import in.shpt.models.products.Product;
import in.shpt.models.products.book.Books;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
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
    Call<CommonCategoryFormat> getLanguages(
            @Query("path") String path,
            @Query("webapi") boolean webapi
    );

    @GET("index.php?route=api/product/usersession")
    Call<ResponseBody> getUserSession();

    @GET("index.php?route=api/product/user")
    Call<ResponseBody> getUserDetails();

    @GET("index.php?route=api/product/loginme")
    Call<ResponseBody> loginMe(@Query("email") String email);

    @GET("index.php?route=account/edit")
    Call<ResponseBody> accountInfo(@Query("webapi") boolean webapi);

    @GET("index.php?route=api/product/mycartcount")
    Call<ResponseBody> cartCount();


    @FormUrlEncoded
    @POST("index.php?route=checkout/cart/add")
    Call<ResponseBody> addToCart(
            @Field("product_id") String product_id,
            @Field("quantity") int quantity
    );


    @FormUrlEncoded
    @POST("index.php?route=account/wishlist/add")
    Call<ResponseBody> addToWishList(
            @Field("product_id") String product_id
    );

    @GET("index.php?route=account/wishlist")
    Call<ResponseBody> getWishList(@Query("webapi") boolean webapi);

    @GET("index.php?route=account/wishlist")
    Call<ResponseBody> removeWishList(@Query("remove") String product_id);

    @GET("index.php?route=checkout/cart")
    Call<ResponseBody> getShoppingCart(@Query("webapi") boolean webapi);

}
