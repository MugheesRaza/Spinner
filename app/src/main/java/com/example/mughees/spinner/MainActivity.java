package com.example.mughees.spinner;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    Spinner spinner,spinner2,spinner3,spinner4;

DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button btn = (Button) findViewById(R.id.btn1);
        databaseReference = FirebaseDatabase.getInstance().getReference("Registration Data");


        spinner = (Spinner) findViewById(R.id.spinner1);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.Items_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        spinner2 = (Spinner) findViewById(R.id.spinner2);
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this, R.array.Items_array2, android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(adapter2);

        spinner3 = (Spinner) findViewById(R.id.spinner3);
        ArrayAdapter<CharSequence> adapter3 = ArrayAdapter.createFromResource(this, R.array.Items_array3, android.R.layout.simple_spinner_item);
        adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner3.setAdapter(adapter3);

        spinner4 = (Spinner) findViewById(R.id.spinner4);
        ArrayAdapter<CharSequence> adapter4 = ArrayAdapter.createFromResource(this, R.array.Items_array4, android.R.layout.simple_spinner_item);
        adapter4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner4.setAdapter(adapter4);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AddData();
                Intent i = new Intent(MainActivity.this,newactivity.class);
                startActivity(i);

            }
        });
    }

    private  void  AddData()
    {
        String sp1 = spinner.getSelectedItem().toString().trim();
        String sp2 = spinner2.getSelectedItem().toString().trim();
        String sp3 = spinner3.getSelectedItem().toString().trim();
        String sp4 = spinner4.getSelectedItem().toString().trim();

        String id = databaseReference.push().getKey();
        Data DBdata = new Data(id,sp1,sp2,sp3,sp4);
        databaseReference.child(id).setValue(DBdata);
        Toast.makeText(this,"Data Added",Toast.LENGTH_SHORT).show();

    }
}