package com.apps.spass.activity;

import android.graphics.Color;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

import com.apps.spass.R;
import com.squareup.picasso.Picasso;

public class MapDetailActivity extends AppCompatActivity {

    private ImageView img;
    String url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map_detail);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.parseColor("#000000"));
        }

        url=getIntent().getExtras().getString("send");
        img=(ImageView)findViewById(R.id.img);

        Picasso.with(getApplicationContext())
                .load(url).
                into(img);
    }
}
