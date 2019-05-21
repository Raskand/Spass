package com.apps.spass.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.apps.spass.R;
import com.apps.spass.adapter.ListAdapter;
import com.apps.spass.model.Lesson;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

import es.dmoral.toasty.Toasty;

public class LessonListActivity extends AppCompatActivity {

    DatabaseReference mRoot = FirebaseDatabase.getInstance().getReference();
    DatabaseReference vData;

    List<Lesson> list = new ArrayList<>();
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson_list);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        initialize();
        loadLesson();
    }

    private void initialize(){

        // Recyclerview -> (ListView) i tanıtıyoruz ve onun layoutmanger tipini belirliyoruz.
        recyclerView=(RecyclerView)findViewById(R.id.recyclerView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);


    }

    private void loadLesson(){

        // Firebase'den Derse ait günlük yoklama verisini child'ı yani tabloyu verileri ile birlikte çekip list'e atıyoruz.
        // List'i de recyclerView için oluşturuduğumuz adapter'e paramtre olarak veriyoruz.
        // Recyclerview'e de adapteri set ediyoruz.

        vData = mRoot.child("Dersler");
        vData.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {

                try {

                    Lesson model = dataSnapshot.getValue(Lesson.class);
                    model.setItemID(dataSnapshot.getKey());
                    list.add(model);
                    recyclerView.setAdapter(new ListAdapter(getApplicationContext(),list));

                }
                catch (Exception e){
                    Toasty.warning(getApplicationContext(), "Veriler Yüklememedi!",
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


    @Override
    public void onBackPressed() {
        Intent i = new Intent(getApplicationContext(),MainActivity.class);
        startActivity(i);
    }



}
