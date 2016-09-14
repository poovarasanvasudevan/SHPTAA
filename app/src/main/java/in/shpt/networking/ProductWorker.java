package in.shpt.networking;

import android.content.Context;
import android.util.Log;

import org.androidannotations.annotations.App;
import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.RootContext;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import in.shpt.application.SHPT;
import in.shpt.models.common.Categories;
import in.shpt.models.language.Category;
import in.shpt.models.language.CommonCategoryFormat;
import in.shpt.models.products.Product;
import in.shpt.models.products.book.Books;
import in.shpt.shptenum.CategoryTypeEnum;

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

    public List<Product> getLatestProducts(int limit) throws IOException {
        return shpt
                .getAdapter()
                .getLatestProducts(limit)
                .execute()
                .body();
    }

    public Books getDefaultBookList(String page, String path, String sort, String order) throws IOException {
        return shpt
                .getAdapter()
                .getDefaultBookList(page, path, sort, order, true)
                .execute()
                .body();


    }

    public HashMap<String, List<Categories>> getLaguageAndAuthors(String path1, String path2) throws IOException {
        List<Categories> author = new ArrayList<>();
        List<Categories> lang = new ArrayList<>();
        CommonCategoryFormat language = shpt.getAdapter().getLanguages(path1, true).execute().body();
        CommonCategoryFormat authors = shpt.getAdapter().getLanguages(path2, true).execute().body();

        for (Category cat : language.getCategories()) {

            String hrefUrl = cat.getHref();

            Categories categories1 = new Categories();
            categories1.setName(cat.getName());
            categories1.setHref(cat.getHref());
            categories1.setPath(hrefUrl.substring(hrefUrl.indexOf("path="), hrefUrl.length()).replace("path=", ""));
            categories1.setCategoryTypeEnum(CategoryTypeEnum.LANGUAGES);

            lang.add(categories1);
        }

        for (Category cat : authors.getCategories()) {

            String hrefUrl = cat.getHref();

            Categories categories1 = new Categories();
            categories1.setName(cat.getName());
            categories1.setHref(cat.getHref());
            categories1.setPath(hrefUrl.substring(hrefUrl.indexOf("path="), hrefUrl.length()).replace("path=", ""));
            categories1.setCategoryTypeEnum(CategoryTypeEnum.LANGUAGES);

            author.add(categories1);
        }


        HashMap<String, List<Categories>> myMap = new HashMap<>();
        myMap.put("language", lang);
        myMap.put("author", author);
        return myMap;
    }

    public JSONObject getUser(String accessCode) throws IOException, JSONException {
        String response = shpt.getAdapter().getUser(accessCode).execute().body().string();
        Log.i("Response123",response);
        return new JSONObject(response);
    }
}
