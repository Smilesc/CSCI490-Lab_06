package com.mad.roomdatabaseintegration.data;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.mad.roomdatabaseintegration.entities.Person;
import com.mad.roomdatabaseintegration.entities.PersonDao;

@Database(entities = {Person.class}, version = 1)
public abstract class LabDatabase extends RoomDatabase {

    public abstract PersonDao personDao();
}

