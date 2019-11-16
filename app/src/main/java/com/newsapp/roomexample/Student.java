package com.newsapp.roomexample;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.databinding.library.baseAdapters.BR;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "students")
public class Student extends BaseObservable {
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

    @Ignore
    public Student() {
    }

    public Student(long id, String name, String email, String date, String country) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.date = date;
        this.country = country;
    }
    @Bindable
    public long getId() { return id; }
    @Bindable
    public String getName() {
        return name;
    }
    @Bindable
    public String getEmail() {
        return email;
    }
    @Bindable
    public String getDate() {
        return date;
    }
    @Bindable
    public String getCountry() {
        return country;
    }

    public void setId(long id) {
        this.id = id;
        notifyPropertyChanged(BR.id);
    }

    public void setName(String name) {
        this.name = name;
        notifyPropertyChanged(BR.name);
    }

    public void setEmail(String email) {
        this.email = email;
        notifyPropertyChanged(BR.email);
    }

    public void setDate(String date) {
        this.date = date;
        notifyPropertyChanged(BR.date);
    }

    public void setCountry(String country) {
        this.country = country;
        notifyPropertyChanged(BR.country);
    }
}
