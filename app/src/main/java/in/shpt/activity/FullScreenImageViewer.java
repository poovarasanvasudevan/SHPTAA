package in.shpt.activity;

import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.squareup.picasso.Picasso;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.Extra;
import org.androidannotations.annotations.ViewById;

import carbon.widget.ImageView;
import carbon.widget.TextView;
import in.shpt.R;

@EActivity(R.layout.activity_full_screen_image_viewer)
public class FullScreenImageViewer extends AppCompatActivity {

    @Extra("description")
    String description;

    @Extra("imageUrl")
    String imageUrl;

    @ViewById
    ImageView fullImage;

    @ViewById
    TextView imageDescription;

    @AfterViews
    public void init() {

        Log.i("imageUrl", imageUrl);

        Picasso.with(this)
                .load("https://shptqa.dev4srcm.org/image/cache/" + imageUrl)
                .fit()
                .centerInside()
                .into(fullImage);

        imageDescription.setText(description);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}
