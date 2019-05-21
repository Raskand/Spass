package com.apps.spass.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.apps.spass.R;

import es.dmoral.toasty.Toasty;

import static com.apps.spass.activity.LoginActivity.statusID;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private TextView txtInspection,txtLessonFull,txtClass;
    private RelativeLayout rltMap;
    public static int sellectedID=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Bu kısım navigationDrawer kullandığımız için default geliyor
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        // View'leri tanıtıyoruz ve onclick veriyoruz.
        txtLessonFull=(TextView)findViewById(R.id.login1);
        txtInspection=(TextView)findViewById(R.id.login2);
        txtClass=(TextView)findViewById(R.id.txt_class);
        rltMap=(RelativeLayout) findViewById(R.id.rlt_info);

        txtLessonFull.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(statusID==2){
                    // Öğretmen ise
                    // Sınıf Listesinine ait Activity'i açar
                    sellectedID=1;
                    Intent i = new Intent(getApplicationContext(),LessonListActivity.class);
                    startActivity(i);
                }
                else{
                    Toasty.error(getApplicationContext(), "Bu sayfaya giriş yetkiniz yok!",
                            Toast.LENGTH_SHORT, true).show();
                }


            }
        });

        txtInspection.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(statusID==1){
                    // Öğrenci ise
                    // Sınıf Listesinine ait Activity'i açar
                    sellectedID=0;
                    Intent i = new Intent(getApplicationContext(),LessonListActivity.class);
                    startActivity(i);
                }

                 else{
                    Toasty.error(getApplicationContext(), "Bu sayfaya giriş yetkiniz yok!",
                            Toast.LENGTH_SHORT, true).show();
                }
            }
        });

        txtClass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               if(statusID==1 || statusID==2){
                   // Öğretmen veya öğrenci ise
                   // Sınıf Doluluk Listesinine ait Activity'i açar
                   Intent i = new Intent(getApplicationContext(),ClassListActivity.class);
                   startActivity(i);
               }
               else{
                   Toasty.error(getApplicationContext(), "Bu sayfaya giriş yetkiniz yok!",
                           Toast.LENGTH_SHORT, true).show();
               }
            }
        });

        rltMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Okul içi haritayı ait Activity'i açar
                Intent i = new Intent(getApplicationContext(),MapActivity.class);
                startActivity(i);
            }
        });
    }

    @Override
    public void onBackPressed() {
        // Geri butonu ve işlevleri
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        }
        else {
            Intent intent = new Intent(Intent.ACTION_MAIN);
            intent.addCategory(Intent.CATEGORY_HOME);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);

        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {

        } else if (id == R.id.nav_gallery) {
            Intent i = new Intent(getApplicationContext(),AbouthActivity.class);
            startActivity(i);

        } else if (id == R.id.nav_slideshow) {
            Intent shareIntent = new Intent(Intent.ACTION_SEND);
            shareIntent.setType("text/plain");
            shareIntent.putExtra(Intent.EXTRA_TEXT, "[Drive Linki]");
            startActivity(Intent.createChooser(shareIntent, "Uygulamayı Paylaş"));

        } else if (id == R.id.nav_manage) {
            Intent i = new Intent(getApplicationContext(),LoginActivity.class);
            startActivity(i);
            finish();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
