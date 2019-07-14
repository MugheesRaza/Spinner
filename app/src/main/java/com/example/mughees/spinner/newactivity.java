package com.example.mughees.spinner;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class newactivity extends Activity {
    DatabaseReference databaseReference;

    ListView DataListView;

    List<Data> dataList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_activity);


        databaseReference = FirebaseDatabase.getInstance().getReference("Registration Data");
        DataListView = (ListView) findViewById(R.id.ListItems);



    }

    @Override
    protected void onStart() {
        super.onStart();
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                dataList.clear();
                for(DataSnapshot DATASNAPSHOT : dataSnapshot.getChildren())
                {

                    Data data = DATASNAPSHOT.getValue(Data.class);
                    dataList.add(data);


                }

                DataList adapter  = new DataList(newactivity.this,dataList);
                DataListView.setAdapter(adapter);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });
    }

}
