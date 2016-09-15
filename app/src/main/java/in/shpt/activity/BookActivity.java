package in.shpt.activity;

import android.graphics.Color;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import com.jayfang.dropdownmenu.DropDownMenu;
import com.jayfang.dropdownmenu.OnMenuSelectedListener;
import com.mikepenz.actionitembadge.library.ActionItemBadge;
import com.mikepenz.ionicons_typeface_library.Ionicons;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.App;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.OptionsItem;
import org.androidannotations.annotations.OptionsMenu;
import org.androidannotations.annotations.OptionsMenuItem;
import org.androidannotations.annotations.ViewById;
import org.json.JSONException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import carbon.widget.ProgressBar;
import in.shpt.R;
import in.shpt.adapter.BookListAdapter;
import in.shpt.application.SHPT;
import in.shpt.models.common.Categories;
import in.shpt.models.products.book.Books;
import in.shpt.models.products.book.Category;
import in.shpt.models.products.book.Sort;
import in.shpt.networking.CartWorker;
import in.shpt.networking.ProductWorker;
import in.shpt.preference.Icons;
import in.shpt.shptenum.AlertMakerEnum;
import in.shpt.ui.AlertMaker;
import in.shpt.widget.EndlessScroll;


@EActivity(R.layout.activity_book)
@OptionsMenu(R.menu.book_menu)
public class BookActivity extends AppCompatActivity {

    @Bean
    ProductWorker productWorker;

    @ViewById
    RecyclerView bookLoader;

    @Bean
    BookListAdapter bookListAdapter;

    @ViewById
    Toolbar toolbar;

    @ViewById
    DropDownMenu languageMenu;

    @Bean
    Icons icons;

    @ViewById
    ProgressBar bookProgress;

    @ViewById
    carbon.widget.FloatingActionButton fabIcon;

    android.widget.PopupMenu languagePopup;

    @App
    SHPT shpt;

    Books books;

    String PATH = "1";

    @ViewById
    AlertMaker alertMaker;
    List<String> sortList;
    List<Sort> sort;
    String page = "";

    String sortingType = null;
    String orderType = null;
    boolean menuAdded = false;
    List<String[]> items = new ArrayList<>();
    List<Categories> lang;
    List<Categories> auth;
    int scrollDY = 0;

    @OptionsMenuItem(R.id.cart)
    MenuItem cart;

    @Bean
    CartWorker cartWorker;

    int cartCount = 0;

    @AfterViews
    public void init() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        LinearLayoutManager llm = new LinearLayoutManager(getApplicationContext());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        bookLoader.setLayoutManager(llm);

        new CartLoader().execute();

        //languageMenu.setImageDrawable(icons.getIcon(Ionicons.Icon.ion_ios_paper, 24, Color.BLACK));
        new AsyncBookLoader().execute("1", "1", sortingType, orderType);





        languageMenu.setmShowCount(6);
        languageMenu.setShowCheck(true);
        languageMenu.setmMenuTitleTextSize(14);
        languageMenu.setmMenuTitleTextColor(Color.parseColor("#777777"));
        languageMenu.setmMenuListTextSize(16);
        languageMenu.setmMenuListTextColor(Color.BLACK);
        languageMenu.setmMenuBackColor(Color.WHITE);
        languageMenu.setmMenuPressedBackColor(Color.parseColor("#eeeeee"));
        languageMenu.setmMenuPressedTitleTextColor(Color.BLACK);
        languageMenu.setmCheckIcon(R.drawable.ico_make);
        languageMenu.setmMenuListBackColor(getResources().getColor(R.color.white));
        languageMenu.setmMenuListSelectorRes(R.color.white);
        languageMenu.setmArrowMarginTitle(20);


        languageMenu.setMenuSelectedListener(new OnMenuSelectedListener() {
            @Override
            public void onSelected(View listview, int RowIndex, int ColumnIndex) {
                switch (ColumnIndex) {
                    case 0: {

                        PATH = lang.get(RowIndex).getPath();
                        page = "1";
                        bookListAdapter.clearData();
                        new AsyncBookLoader().execute(String.valueOf(page), PATH, sortingType, orderType);

                        break;

                    }
                    case 1: {
                        PATH = auth.get(RowIndex).getPath();
                        page = "1";
                        bookListAdapter.clearData();
                        new AsyncBookLoader().execute(String.valueOf(page), PATH, sortingType, orderType);
                        break;
                    }
                    case 2: {
                        String[] splitType = sort.get(RowIndex).getValue().split("-");
                        sortingType = splitType[0];
                        orderType = splitType[1];
                        page = "1";
                        bookListAdapter.clearData();
                        new AsyncBookLoader().execute(String.valueOf(page), PATH, sortingType, orderType);
                        break;
                    }

                }

            }
        });

        bookLoader.addOnScrollListener(new EndlessScroll(llm) {
            @Override
            public void onLoadMore(int page, int totalItemsCount) {
                new AsyncBookLoader().execute(String.valueOf(page + 1), PATH, sortingType, orderType);

            }
        });


    }

    RecyclerView.OnScrollListener listener = new RecyclerView.OnScrollListener() {
        @Override
        public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
            super.onScrollStateChanged(recyclerView, newState);
        }

        @Override
        public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
            scrollDY += dy;
            if (scrollDY > 1500) {
                fabIcon.setVisibility(View.VISIBLE);
            } else {
                fabIcon.setVisibility(View.GONE);
            }
            super.onScrolled(recyclerView, dx, dy);
        }
    };

    @Click(R.id.fabIcon)
    public void fabIconClicked(View v) {
        bookLoader.smoothScrollToPosition(0);
        v.setVisibility(View.GONE);
    }

    @OptionsMenuItem(R.id.cart)
    void injectCartMenu(MenuItem cartItem) {
        cartItem.setIcon(icons.getIcon(Ionicons.Icon.ion_ios_cart));

    }

    class CartLoader extends AsyncTask<Void, Void, Integer> {
        @Override
        protected Integer doInBackground(Void... voids) {
            try {
                return cartWorker.getCartCount();
            } catch (JSONException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

            return null;
        }

        @Override
        protected void onPostExecute(Integer integer) {

            cartCount = integer;
            if (integer != null) {
                if (cartCount > 0) {
                    ActionItemBadge.update(BookActivity.this, cart, Ionicons.Icon.ion_ios_cart, ActionItemBadge.BadgeStyles.RED, cartCount);
                } else {
                    ActionItemBadge.hide(cart);
                }
            }
            super.onPostExecute(integer);
        }
    }

    class AsyncBookLoader extends AsyncTask<String, Void, Books> {

        boolean isSorted = false;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            if (shpt.isInternetAvailable()) {
                bookProgress.setVisibility(View.VISIBLE);
            }
        }


        @Override
        protected Books doInBackground(String... strings) {
            try {
                page = strings[0];
                if (strings[2] != null)
                    isSorted = true;


                if (shpt.isInternetAvailable()) {

                    return productWorker.getDefaultBookList(strings[0], strings[1], strings[2], strings[3]);
                } else {
                    return null;
                }
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }

        @Override
        protected void onPostExecute(Books bookList) {
            super.onPostExecute(bookList);
            if (bookList != null) {
                if (page == "1") {

                    getSupportActionBar().setTitle(bookList.getHeadingTitle());
                    getSupportActionBar().setSubtitle(bookList.getDescription());

                    if (menuAdded == false) {
                        books = bookList;

                        List<String> title = new ArrayList<>();
                        List<String> href = new ArrayList<>();

                        for (Category category : bookList.getCategories()) {
                            String hrefUrl = category.getHref();
                            title.add(category.getName());
                            href.add(hrefUrl.substring(hrefUrl.indexOf("path="), hrefUrl.length()).replace("path=", "").replace(":", "").trim());
                        }

                        title.add("SORT");
                        languageMenu.setmMenuCount(title.size());
                        languageMenu.setDefaultMenuTitle(title.toArray(new String[0]));

                        new LanguageAndAuthorLoader().execute(href.get(0), href.get(1));

                        fabIcon.setVisibility(View.GONE);
                        scrollDY = 0;

                        bookLoader.addOnScrollListener(listener);
                        menuAdded = true;
                    }


                    // bookListAdapter.clearData();
                    bookListAdapter.addData(bookList.getProducts());
                    bookLoader.setAdapter(bookListAdapter);

                    bookProgress.setVisibility(View.GONE);
                } else {
                    bookListAdapter.appendData(bookList.getProducts());
                    bookProgress.setVisibility(View.GONE);
                }
            } else {
                alertMaker.makeAlert(getString(R.string.server_error), AlertMakerEnum.FAILURE, true);
            }
        }
    }

    class LanguageAndAuthorLoader extends AsyncTask<String, Void, HashMap<String, List<Categories>>> {

        @Override
        protected HashMap<String, List<Categories>> doInBackground(String... strings) {
            try {
                return productWorker.getLaguageAndAuthors(
                        strings[0],
                        strings[1]
                );
            } catch (IOException e) {
                e.printStackTrace();

                return null;
            }
        }

        @Override
        protected void onPostExecute(HashMap<String, List<Categories>> stringListHashMap) {
            super.onPostExecute(stringListHashMap);

            if (stringListHashMap != null) {
                lang = stringListHashMap.get("language");
                auth = stringListHashMap.get("author");

                List<String> langString = new ArrayList<>();
                List<String> authString = new ArrayList<>();

                for (Categories c : lang) {
                    langString.add(c.getName());

                }
                for (Categories c : auth) {
                    authString.add(c.getName());

                }

                items.add(langString.toArray(new String[0]));
                items.add(authString.toArray(new String[0]));
                sortList = new ArrayList<>();
                sort = new ArrayList<>();
                for (Sort sorts : books.getSorts()) {
                    sortList.add(sorts.getText().replace("&gt;", ">"));
                    sort.add(sorts);

                }

                items.add(sortList.toArray(new String[0]));
                languageMenu.setmMenuItems(items);
                languageMenu.setmUpArrow(R.drawable.arrow_up);
                languageMenu.setmDownArrow(R.drawable.arrow_down);

            }
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        page = "1";
        PATH = "1";
    }

    @Override
    protected void onPause() {
        super.onPause();
        page = "1";
        PATH = "1";
    }

    @OptionsItem(android.R.id.home)
    public void homeClicked() {
        finish();
        //bookListAdapter.clearData();
    }
}
