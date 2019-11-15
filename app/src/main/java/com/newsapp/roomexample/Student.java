package com.newsapp.roomexample;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "students")
public class Student {
    @ColumnInfo(name = "student_id")
    @PrimaryKey(autoGenerate = true)
    private long id;

    @ColumnInfo(name = "student_name")
    private String name;

    @ColumnInfo(name = "student_email")
    private String email;

    @ColumnInfo(name = "register_date")
    private String date;

    @ColumnInfo(name = "student_country")
    private String country;

    public Student(long id, String name, String email, String date, String country) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.date = date;
        this.country = country;
    }

    public long getId() { return id; }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getDate() {
        return date;
    }

    public String getCountry() {
        return country;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
