package com.mad.roomdatabaseintegration;

import android.arch.persistence.room.Room;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.mad.roomdatabaseintegration.asyncs.AsyncTask1;
import com.mad.roomdatabaseintegration.asyncs.AsyncTask2;
import com.mad.roomdatabaseintegration.data.LabDatabase;
import com.mad.roomdatabaseintegration.entities.Person;

public class MainActivity extends AppCompatActivity {
    Button submitName;
    Button listNames;
    EditText name;
    String DATABASE_NAME = "dB";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        submitName = findViewById(R.id.submitName);
        listNames = findViewById(R.id.listNames);
        name = findViewById(R.id.name);

        final LabDatabase labDatabase = Room.databaseBuilder(this, LabDatabase.class, DATABASE_NAME)
                .build();

        submitName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String currName = name.getText().toString();
                Toast.makeText(MainActivity.this, getResources().getString(R.string.name_added), Toast.LENGTH_SHORT).show();

                Person person = new Person();
                person.setName(currName);
                AsyncTask1 insert = new AsyncTask1(labDatabase, person);
                insert.execute();
            }
        });

        listNames.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AsyncTask2 retrieve = new AsyncTask2(labDatabase, getApplicationContext());
                retrieve.execute();
            }
        });


    }
}
