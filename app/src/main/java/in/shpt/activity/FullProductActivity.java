package in.shpt.activity;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.mikepenz.ionicons_typeface_library.Ionicons;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.Extra;
import org.androidannotations.annotations.OptionsItem;
import org.androidannotations.annotations.OptionsMenu;
import org.androidannotations.annotations.OptionsMenuItem;
import org.androidannotations.annotations.ViewById;

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
    TextView viewProductTitle;

    @ViewById
    TextView viewDescriptionText;

    @ViewById
    ImageView viewProductImage;

    @ViewById
    Toolbar toolbar;

    @Bean
    Icons icons;

    @AfterViews
    public void init() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);


        viewProductTitle.setText(product.getName());
        //viewDescriptionText.setText("\t\t"+product.getDescription());
        icons.displayImage(product.getImage(), viewProductImage);
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


}
