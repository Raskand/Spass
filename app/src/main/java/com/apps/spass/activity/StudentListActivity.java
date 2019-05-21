
package com.apps.spass.activity;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.apps.spass.R;
import com.apps.spass.adapter.StudentAdapter;
import com.apps.spass.model.Inspection;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import es.dmoral.toasty.Toasty;

public class StudentListActivity extends AppCompatActivity {

    DatabaseReference mRoot = FirebaseDatabase.getInstance().getReference();
    DatabaseReference vData;

    List<Inspection> list = new ArrayList<>();
    RecyclerView recyclerView;
    String dateTime,id,itemID;
    Button btnClose;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_list);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        initialize();
        loadStudent();

    }
    private void initialize(){

        long msTime = System.currentTimeMillis();
        Date curDateTime = new Date(msTime);
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        dateTime = formatter.format(curDateTime);
        id=getIntent().getExtras().getString("id");
        itemID=getIntent().getExtras().getString("itemID");


        // Recyclerview -> (ListView) i tanıtıyoruz ve onun layoutmanger tipini belirliyoruz.
        recyclerView=(RecyclerView)findViewById(R.id.recyclerView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        btnClose=(Button)findViewById(R.id.btn_close);
        btnClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vData = FirebaseDatabase.getInstance().getReference("Sınıf Listesi");
                vData.child(itemID+"/size").setValue(String.valueOf("0"));

                mRoot = FirebaseDatabase.getInstance().getReference("Dersler");
                mRoot.child(itemID+"/size").setValue(String.valueOf("0"));

                Toasty.Config.getInstance()
                        .setTextColor(Color.WHITE)
                        .apply();
                Toasty.custom(getApplicationContext(),"Yoklama kapatıldı",
                        getResources().getDrawable(R.drawable.ic_check_white_48dp),
                        Color.parseColor("#0FDDBB"), 2500, true, true).show();
                Toasty.Config.reset();

                Intent i = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(i);
            }
        });

    }

    private void loadStudent(){

        // Firebase'den Dersler isimli child'ı yani tabloyu verileri ile birlikte çekip list'e atıyoruz.
        // List'i de recyclerView için oluşturuduğumuz adapter'e paramtre olarak veriyoruz.
        // Recyclerview'e de adapteri set ediyoruz.

        vData = mRoot.child("Yoklama/"+dateTime+"/"+id);
        vData.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {

                try {

                    Inspection model = dataSnapshot.getValue(Inspection.class);
                    list.add(model);
                    recyclerView.setAdapter(new StudentAdapter(getApplicationContext(),list));

                }
                catch (Exception e){
                    Toasty.warning(getApplicationContext(), "Okutulan QR Kod ile dersin ID'si eşleşmemektedir!",
                            Toast.LENGTH_SHORT, true).show();

                }
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }


    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }


}

