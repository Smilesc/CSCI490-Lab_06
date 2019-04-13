package com.mad.roomdatabaseintegration.asyncs;

import android.os.AsyncTask;

import com.mad.roomdatabaseintegration.data.LabDatabase;
import com.mad.roomdatabaseintegration.entities.Person;

public class AsyncTask1 extends AsyncTask {
    LabDatabase database;
    Person person;
    public AsyncTask1(LabDatabase database, Person person){
        this.database = database;
        this.person = person;
    }
    @Override
    protected Object doInBackground(Object[] objects) {
        database.personDao().insertPerson(person);
        return null;
    }
}
