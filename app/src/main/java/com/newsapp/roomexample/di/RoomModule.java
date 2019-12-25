package com.newsapp.roomexample.di;

import android.app.Application;

import androidx.room.Room;

import com.newsapp.roomexample.db.StudentsDatabase;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class RoomModule {

    @Provides
    @Singleton
    StudentsDatabase provideStudentDatabase(Application application){
        return Room.databaseBuilder(application, StudentsDatabase.class,"StudentsDB").build();
    }
}
