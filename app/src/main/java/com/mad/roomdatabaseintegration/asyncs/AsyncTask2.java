package com.mad.roomdatabaseintegration.asyncs;


import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;

import com.mad.roomdatabaseintegration.PersonsActivity;
import com.mad.roomdatabaseintegration.data.LabDatabase;
import com.mad.roomdatabaseintegration.entities.Person;

import java.util.ArrayList;
import java.util.List;

public class AsyncTask2 extends AsyncTask {
    Context context;
    LabDatabase database;
    private List<Person> persons;

    public AsyncTask2(LabDatabase database, Context context){
        this.context = context;
        this.database = database;

    }

    @Override
    protected Object doInBackground(Object[] objects) {
        ArrayList<String> personNames = new ArrayList<>();
        persons = database.personDao().getAllPersons();
        for(Person p: persons) {
            personNames.add(p.getName());
        }

        Intent i = new Intent(context, PersonsActivity.class);
        i.putExtra("Persons", personNames);
        context.startActivity(i);
        return null;
    }
}
