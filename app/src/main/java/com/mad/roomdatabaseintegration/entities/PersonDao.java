package com.mad.roomdatabaseintegration.entities;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface PersonDao {
    @Insert
    void insertPerson(Person person);

    @Query("SELECT * FROM Person")
    List<Person> getAllPersons();
}
