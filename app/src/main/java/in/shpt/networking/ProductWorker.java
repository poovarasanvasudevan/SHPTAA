package in.shpt.networking;

import android.content.Context;

import org.androidannotations.annotations.App;
import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.RootContext;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import in.shpt.application.SHPT;
import in.shpt.models.common.Categories;
import in.shpt.models.language.Category;
import in.shpt.models.language.CommonCategoriesFormat;
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

    public List<Categories> getLaguageAndAuthors(String path1,String path2) throws IOException {
        List<Categories> categories = new ArrayList<>();
        CommonCategoriesFormat language = shpt.getAdapter().getLanguages(path1, true).execute().body();
        CommonCategoriesFormat authors = shpt.getAdapter().getLanguages(path2, true).execute().body();

        for (Category cat: language.getCategories()) {

            String hrefUrl = cat.getHref();

            Categories categories1 = new Categories();
            categories1.setName(cat.getName());
            categories1.setHref(cat.getHref());
            categories1.setPath(hrefUrl.substring(hrefUrl.indexOf("path="), hrefUrl.length()).replace("path=",""));
            categories1.setCategoryTypeEnum(CategoryTypeEnum.LANGUAGES);

            categories.add(categories1);
        }

        for (Category cat: authors.getCategories()) {

            String hrefUrl = cat.getHref();

            Categories categories1 = new Categories();
            categories1.setName(cat.getName());
            categories1.setHref(cat.getHref());
            categories1.setPath(hrefUrl.substring(hrefUrl.indexOf("path="), hrefUrl.length()).replace("path=",""));
            categories1.setCategoryTypeEnum(CategoryTypeEnum.LANGUAGES);

            categories.add(categories1);
        }


        return categories;
    }
}
