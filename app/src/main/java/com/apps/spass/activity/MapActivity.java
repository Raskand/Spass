package com.apps.spass.activity;

import android.content.Intent;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.apps.spass.R;

public class MapActivity extends AppCompatActivity {

    private TextView txt1,txt2,txt3,txt4,txt5,txt6,txt7,txt8,txt9,txt10,txt11,txt12,txt13,txt14,txt15;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        initialize();
        suitUp();
    }

    private void initialize(){

        txt1=(TextView)findViewById(R.id.txt1);
        txt2=(TextView)findViewById(R.id.txt2);
        txt3=(TextView)findViewById(R.id.txt3);
        txt4=(TextView)findViewById(R.id.txt4);
        txt5=(TextView)findViewById(R.id.txt5);
        txt6=(TextView)findViewById(R.id.txt6);
        txt7=(TextView)findViewById(R.id.txt7);
        txt8=(TextView)findViewById(R.id.txt8);
        txt9=(TextView)findViewById(R.id.txt9);
        txt10=(TextView)findViewById(R.id.txt10);
        txt11=(TextView)findViewById(R.id.txt11);
        txt12=(TextView)findViewById(R.id.txt12);
        txt13=(TextView)findViewById(R.id.txt13);
        txt14=(TextView)findViewById(R.id.txt14);
        txt15=(TextView)findViewById(R.id.txt15);

    }

    private void suitUp(){

        txt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),MapDetailActivity.class);
                i.putExtra("send","https://i.hizliresim.com/ZX8QQa.png");
                startActivity(i);
            }
        });

        txt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),MapDetailActivity.class);
                i.putExtra("send","https://i.hizliresim.com/ZX8QQa.png");
                startActivity(i);
            }
        });

        txt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),MapDetailActivity.class);
                i.putExtra("send","https://i.hizliresim.com/ZX8QQa.png");
                startActivity(i);
            }
        });

        txt4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),MapDetailActivity.class);
                i.putExtra("send","https://i.hizliresim.com/ZX8QQa.png");
                startActivity(i);
            }
        });

        txt5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),MapDetailActivity.class);
                i.putExtra("send","https://i.hizliresim.com/ZX8QQa.png");
                startActivity(i);
            }
        });

        txt6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),MapDetailActivity.class);
                i.putExtra("send","https://i.hizliresim.com/ZX8QQa.png");
                startActivity(i);
            }
        });

        txt7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),MapDetailActivity.class);
                i.putExtra("send","https://i.hizliresim.com/ZX8QQa.png");
                startActivity(i);
            }
        });

        txt8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),MapDetailActivity.class);
                i.putExtra("send","https://i.hizliresim.com/ZX8QQa.png");
                startActivity(i);
            }
        });

        txt9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),MapDetailActivity.class);
                i.putExtra("send","https://i.hizliresim.com/ZX8QQa.png");
                startActivity(i);
            }
        });

        txt10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),MapDetailActivity.class);
                i.putExtra("send","https://i.hizliresim.com/ZX8QQa.png");
                startActivity(i);
            }
        });

        txt11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),MapDetailActivity.class);
                i.putExtra("send","https://i.hizliresim.com/ZX8QQa.png");
                startActivity(i);
            }
        });

        txt12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),MapDetailActivity.class);
                i.putExtra("send","https://i.hizliresim.com/ZX8QQa.png");
                startActivity(i);
            }
        });

        txt13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),MapDetailActivity.class);
                i.putExtra("send","https://i.hizliresim.com/ZX8QQa.png");
                startActivity(i);
            }
        });

        txt14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),MapDetailActivity.class);
                i.putExtra("send","https://i.hizliresim.com/ZX8QQa.png");
                startActivity(i);
            }
        });

        txt15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),MapDetailActivity.class);
                i.putExtra("send","https://i.hizliresim.com/ZX8QQa.png");
                startActivity(i);
            }
        });

    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    @Override
    public void onBackPressed() {
        Intent i = new Intent(getApplicationContext(),MainActivity.class);
        startActivity(i);
    }


}
