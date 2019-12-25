package com.newsapp.roomexample.di;

import com.newsapp.roomexample.MainActivity;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {ApplicationModule.class,RoomModule.class})
public interface StudentAppComponent {
    void inject(MainActivity mainActivity);
}
