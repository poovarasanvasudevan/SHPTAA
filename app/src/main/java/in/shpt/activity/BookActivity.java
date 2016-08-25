package in.shpt.activity;

import android.graphics.Color;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import com.jayfang.dropdownmenu.DropDownMenu;
import com.jayfang.dropdownmenu.OnMenuSelectedListener;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.App;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.OptionsItem;
import org.androidannotations.annotations.ViewById;

import java.util.ArrayList;
import java.util.List;

import carbon.widget.ProgressBar;
import in.shpt.R;
import in.shpt.adapter.BookListAdapter;
import in.shpt.application.SHPT;
import in.shpt.models.products.book.Books;
import in.shpt.models.products.book.Sort;
import in.shpt.networking.ProductWorker;
import in.shpt.preference.Icons;
import in.shpt.shptenum.AlertMakerEnum;
import in.shpt.ui.AlertMaker;
import in.shpt.widget.EndlessScroll;
import in.shpt.widget.LanguageContextMenu;


@EActivity(R.layout.activity_book)
public class BookActivity extends AppCompatActivity implements LanguageContextMenu.OnFeedContextMenuItemClickListener {

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

    android.widget.PopupMenu languagePopup;

    @App
    SHPT shpt;

    @ViewById
    AlertMaker alertMaker;

    final String[] authorArray = new String[]{"全部城市", "北京", "上海", "广州", "深圳"};
    final String[] sortArray = new String[]{"性别", "男", "女"};


    String[] Language;
    List<String> sortList;
    List<Sort> sort;
    String page = "";

    String sortingType = null;
    String orderType = null;
    boolean menuAdded = false;

    @AfterViews
    public void init() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        LinearLayoutManager llm = new LinearLayoutManager(getApplicationContext());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        bookLoader.setLayoutManager(llm);


        //languageMenu.setImageDrawable(icons.getIcon(Ionicons.Icon.ion_android_apps, 24, Color.BLACK));
        new AsyncBookLoader().execute("1", "1", sortingType, orderType);


        Language = new String[]{
                "Author",
                "Sort",
                "Language"
        };
        languageMenu.setmMenuCount(3);
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
        languageMenu.setmUpArrow(R.drawable.arrow_up);
        languageMenu.setmDownArrow(R.drawable.arrow_down);
        languageMenu.setShowDivider(true);
        languageMenu.setmMenuListBackColor(getResources().getColor(R.color.white));
        languageMenu.setmMenuListSelectorRes(R.color.white);
        languageMenu.setmArrowMarginTitle(20);
        languageMenu.setDefaultMenuTitle(Language);


        languageMenu.setMenuSelectedListener(new OnMenuSelectedListener() {
            @Override
            public void onSelected(View listview, int RowIndex, int ColumnIndex) {
                switch (ColumnIndex) {
                    case 0:

                        break;

                    case 1: {
                        String[] splitType = sort.get(RowIndex).getValue().split("-");
                        sortingType = splitType[0];
                        orderType = splitType[1];
                        page = "1";
                        bookListAdapter.clearData();
                        new AsyncBookLoader().execute(String.valueOf(page), "1", sortingType, orderType);
                        break;
                    }
                    case 2:

                        break;
                }
                Log.i("MainActivity", "select " + ColumnIndex + " column and " + RowIndex + " row");
            }
        });

        bookLoader.addOnScrollListener(new EndlessScroll(llm) {
            @Override
            public void onLoadMore(int page, int totalItemsCount) {
                new AsyncBookLoader().execute(String.valueOf(page), "1", sortingType, orderType);
            }
        });


    }

    @Override
    public void onReportClick(int feedItem) {

    }

    @Override
    public void onSharePhotoClick(int feedItem) {

    }

    @Override
    public void onCopyShareUrlClick(int feedItem) {

    }

    @Override
    public void onCancelClick(int feedItem) {

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
                        sortList = new ArrayList<>();
                        sort = new ArrayList<>();
                        for (Sort sorts : bookList.getSorts()) {
                            sortList.add(sorts.getText().replace("&gt;", ">"));
                            sort.add(sorts);

                        }
                        List<String[]> items = new ArrayList<>();
                        items.add(authorArray);
                        items.add(sortList.toArray(new String[0]));
                        items.add(sortArray);
                        languageMenu.setmMenuItems(items);
                        languageMenu.setmUpArrow(R.drawable.arrow_up);
                        languageMenu.setmDownArrow(R.drawable.arrow_down);
                        menuAdded = true;
                    }


                    bookListAdapter.addData(bookList.getProducts());
                    bookLoader.setAdapter(bookListAdapter);

                    bookProgress.setVisibility(View.GONE);
                } else {
                    bookListAdapter.appendData(bookList.getProducts());
                    bookProgress.setVisibility(View.GONE);
                }
            } else {
                alertMaker.makeAlert(getString(R.string.no_internet_connection), AlertMakerEnum.FAILURE, true);
            }
        }
    }


    @OptionsItem(android.R.id.home)
    public void homeClicked() {
        finish();
        //bookListAdapter.clearData();
    }
}
