package com.apps.spass.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.apps.spass.R;

public class LoginActivity extends AppCompatActivity {

    private TextView login1,login2,login3;
    public static int statusID=2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        login1=(TextView)findViewById(R.id.login1);
        login2=(TextView)findViewById(R.id.login2);
        login3=(TextView)findViewById(R.id.login3);

        login1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                statusID=1;
                Intent i = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(i);
                finish();
            }
        });

        login2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                statusID=2;
                Intent i = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(i);
                finish();
            }
        });

        login3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                statusID=0;
                Intent i = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(i);
                finish();
            }
        });
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_HOME);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }

}
