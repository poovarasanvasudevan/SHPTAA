package in.shpt.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.TableLayout;
import android.widget.TableRow;

import com.mikepenz.ionicons_typeface_library.Ionicons;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.Extra;
import org.androidannotations.annotations.OptionsItem;
import org.androidannotations.annotations.OptionsMenu;
import org.androidannotations.annotations.OptionsMenuItem;
import org.androidannotations.annotations.ViewById;

import java.math.BigDecimal;
import java.math.RoundingMode;

import carbon.widget.ImageView;
import carbon.widget.TextView;
import in.shpt.R;
import in.shpt.models.products.Product;
import in.shpt.preference.Icons;


@EActivity(R.layout.activity_full_product)
@OptionsMenu(R.menu.home_menu)
public class FullProductActivity extends AppCompatActivity {

    @Extra("Product")
    Product product;

    @ViewById
    TextView viewProductTitle, viewProductCost;


    @ViewById
    ImageView viewProductImage;

    @ViewById
    Toolbar toolbar;

    @Bean
    Icons icons;

    @ViewById
    TableLayout viewProductDetail;

    String imageUrl = "";
    @AfterViews
    public void init() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle(product.getName());
        getSupportActionBar().setSubtitle(product.getManufacturer());


        boolean isJpg = product.getImage().contains(".jpg");


        imageUrl = product.getImage().replace(".png", "");
        imageUrl = imageUrl.replace(".jpg", "");
        imageUrl = imageUrl + "-550x550";

        if (isJpg)
            imageUrl = imageUrl + ".jpg";
        else
            imageUrl = imageUrl + ".png";


        viewProductTitle.setText(product.getName());
        viewProductCost.setText("₹ " + new BigDecimal(product.getPrice()).setScale(2, RoundingMode.HALF_UP).doubleValue());
        //viewDescriptionText.setText("\t\t"+product.getDescription());
        icons.displayImage(product.getImage(), viewProductImage);

        initTable();
    }

    @Click(R.id.viewProductImage)
    public void imageClicked(View v){
        FullScreenImageViewer_
                .intent(getApplicationContext())
                .flags(Intent.FLAG_ACTIVITY_NEW_TASK)
                .description(product.getName())
                .imageUrl(imageUrl)
                .start();
    }

    @OptionsMenuItem(R.id.cartMenu)
    void injectCartMenu(MenuItem cartItem) {
        cartItem.setIcon(icons.getIcon(Ionicons.Icon.ion_ios_cart));
    }

    @OptionsMenuItem(R.id.notificationMenu)
    void injectNotificationMenu(MenuItem notificationItem) {
        notificationItem.setIcon(icons.getIcon(Ionicons.Icon.ion_ios_bell));
    }

    @OptionsItem(android.R.id.home)
    void goBack() {
        finish();
    }

    public void initTable() {
        TableRow row = new TableRow(this);
        TextView titleText = new TextView(this);
        titleText.setText("Publication Date");
        row.addView(titleText);

        TextView valueText = new TextView(this);
        valueText.setText(product.getDate_added());
        row.addView(valueText);

        viewProductDetail.addView(row);
    }

}
