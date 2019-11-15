package com.newsapp.roomexample;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Student.class},version = 1)
public abstract class StudentsDatabase extends RoomDatabase {

    public abstract StudentDAO getStudentDAO();
}
