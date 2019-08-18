package com.example.android.projectnetintel;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class MenuActivity extends AppCompatActivity {

    RecyclerView MenuRecyclerview;
    //Button pbutton;
    MenuActivityAdapter menuAdapter;
    List<MenuItems> mData;
    MenuItems mI;
    FirebaseDatabase database;
    DatabaseReference ref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //requestWindowFeature(Window.FEATURE_NO_TITLE);
        //getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_menu);

        //getSupportActionBar().hide();

        MenuRecyclerview = findViewById(R.id.menuList_rv);
        //pbutton = findViewById(R.id.purchaseBtn);
        mData = new ArrayList<>();

        mI = new MenuItems();
        database = FirebaseDatabase.getInstance();
        ref = database.getReference("menuItem");

        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot ds : dataSnapshot.getChildren()) {

                    mI = ds.getValue(MenuItems.class);
                    mData.add(mI);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        //add Data
        //mData.add(new MenuItems("Jollof Rice and Chicken","White rice with tomato sauce",R.drawable.jollofrice));
       // mData.add(new MenuItems("Fried Rice and Suya Chicken","Sweet fried rice with special grilled suya chicken ",R.drawable.friedricesuyachicken,20.00));
        mData.add(new MenuItems("Peppered Gizzard","Nigerian Peppered Gizzards is the ”Nigerian-style stewed gizzards”.It is popularly known as food for festive events.",R.drawable.pepperedgizard, 15.24));
        mData.add(new MenuItems("Egusi Soup","Egusi soup is popular in Western Africa. The soup is thickened with ground melon, gourd, or squash seeds." ,R.drawable.poundedyamandegusisoup, 20.24));

        menuAdapter = new MenuActivityAdapter(this,mData);
        MenuRecyclerview.setAdapter(menuAdapter);
        MenuRecyclerview.setLayoutManager(new LinearLayoutManager(this));

    }
}
