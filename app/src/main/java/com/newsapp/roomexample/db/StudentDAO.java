package com.newsapp.roomexample.db;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface StudentDAO {

    @Insert
    public long addStudent(Student student);

    @Delete
    public void deleteStudent(Student student);

    @Query("select * from students")
    public List<Student> getStudents();

    @Query("select * from students where student_id == :student_id")
    public Student getStudent(long student_id);

}
