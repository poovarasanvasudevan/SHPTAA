package in.shpt.activity;

import android.graphics.Color;
import android.os.AsyncTask;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.mikepenz.ionicons_typeface_library.Ionicons;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Background;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.OptionsItem;
import org.androidannotations.annotations.OptionsMenu;
import org.androidannotations.annotations.OptionsMenuItem;
import org.androidannotations.annotations.ViewById;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;

import carbon.widget.LinearLayout;
import in.shpt.R;
import in.shpt.core.models.SHPTNavMenu;
import in.shpt.models.products.Product;
import in.shpt.networking.ProductWorker;
import in.shpt.preference.Icons;
import in.shpt.shptenum.AlertMakerEnum;
import in.shpt.ui.AlertMaker;
import in.shpt.ui.ProductSwipeCard;

@EActivity(R.layout.activity_home)
@OptionsMenu(R.menu.home_menu)
public class HomeActivity extends AppCompatActivity {

    @ViewById
    Toolbar toolbar;

    @ViewById
    DrawerLayout drawer;

    @ViewById
    NavigationView navigationView;

    Menu navMenu;

    @ViewById
    EditText searchView;

    @ViewById
    ImageButton searchButton;

    @ViewById
    LinearLayout networkProblemLayout;

    Boolean connection;

    @Bean
    ProductWorker productWorker;

    @ViewById
    AlertMaker alertMaker;

    @ViewById
    ProductSwipeCard latestProduct;

    @Bean
    Icons icons;

    @AfterViews
    public void init() {

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);


        searchButton.setImageDrawable(icons.getIcon(Ionicons.Icon.ion_ios_search, 20, Color.DKGRAY));

        setUpNavBarMenu();


        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {

                drawer.closeDrawers();

                return false;
            }
        });


        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.openDrawer, R.string.closeDrawer) {

            @Override
            public void onDrawerClosed(View drawerView) {
                // Code here will be triggered once the drawer closes as we dont want anything to happen so we leave this blank
                super.onDrawerClosed(drawerView);
            }

            @Override
            public void onDrawerOpened(View drawerView) {
                // Code here will be triggered once the drawer open as we dont want anything to happen so we leave this blank

                super.onDrawerOpened(drawerView);
            }
        };

        //Setting the actionbarToggle to drawer layout
        drawer.setDrawerListener(actionBarDrawerToggle);

        //calling sync state is necessay or else your hamburger icon wont show up
        actionBarDrawerToggle.syncState();

        new LatestProductLoader().execute(5);

    }

    @Override
    protected void onPause() {
        super.onPause();
        EventBus.getDefault().unregister(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        EventBus.getDefault().register(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    class LatestProductLoader extends AsyncTask<Integer, Void, HashMap<String, List<Product>>> {
        @Override
        protected HashMap<String, List<Product>> doInBackground(Integer... integers) {
            try {
                HashMap<String, List<Product>> productHash = new HashMap<>();
                productHash.put("latest", productWorker.getLatestProducts(integers[0]));
                productHash.put("popular", productWorker.getLatestProducts(integers[0]));
                return productHash;
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(HashMap<String, List<Product>> products) {
            latestProduct.setUpPager(getSupportFragmentManager(), products.get("latest"));
            //homeSwipePager.setUp(getSupportFragmentManager(), products);
            super.onPostExecute(products);
        }
    }


    @Background
    public void setUpNavBarMenu() {
        Type listType = new TypeToken<List<SHPTNavMenu>>() {
        }.getType();
        List<SHPTNavMenu> yourList = new Gson().fromJson(readNavBar(), listType);

        navMenu = navigationView.getMenu();
        for (int i = 0; i < yourList.size(); i++) {
            SubMenu submenu = navMenu.addSubMenu(yourList.get(i).getTitle());
            for (int j = 0; j < yourList.get(i).getChild().size(); j++) {
                submenu.add(yourList.get(i).getChild().get(j).getName())
                        .setIcon(icons.getIcon(yourList.get(i).getChild().get(j).getIcon()));
            }
        }
    }

    private String readNavBar() {

        InputStream inputStream;
        ByteArrayOutputStream byteArrayOutputStream = null;

        try {
            inputStream = getApplicationContext().getAssets().open("config/navigation.json");
            System.out.println(inputStream);
            byteArrayOutputStream = new ByteArrayOutputStream();

            int i;
            i = inputStream.read();
            while (i != -1) {
                byteArrayOutputStream.write(i);
                i = inputStream.read();
            }
            inputStream.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return byteArrayOutputStream.toString();
    }

    @OptionsMenuItem(R.id.cartMenu)
    void injectCartMenu(MenuItem cartItem) {
        cartItem.setIcon(icons.getIcon(Ionicons.Icon.ion_ios_cart));
    }

    @OptionsMenuItem(R.id.notificationMenu)
    void injectNotificationMenu(MenuItem notificationItem) {
        notificationItem.setIcon(icons.getIcon(Ionicons.Icon.ion_ios_bell));
    }

    @OptionsItem(R.id.notificationMenu)
    void makeNotify() {
        alertMaker.makeAlert("Notification Text", AlertMakerEnum.FAILURE);
    }


    @Subscribe(threadMode = ThreadMode.MAIN)
    public void connectionResult(Boolean result) {
        if (result) {
            connection = true;
            networkProblemLayout.setVisibility(View.GONE);
        } else {
            connection = false;
            networkProblemLayout.setVisibility(View.VISIBLE);
        }
    }
}
