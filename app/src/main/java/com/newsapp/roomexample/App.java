package com.newsapp.roomexample;

import android.app.Application;

import com.newsapp.roomexample.di.ApplicationModule;
import com.newsapp.roomexample.di.DaggerStudentAppComponent;
import com.newsapp.roomexample.di.StudentAppComponent;

public class App extends Application {

    public static App app;
    private StudentAppComponent studentAppComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        app=this;

        studentAppComponent= DaggerStudentAppComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();
    }

    public static App getApp() {
        return app;
    }

    public StudentAppComponent getStudentAppComponent() {
        return studentAppComponent;
    }
}
