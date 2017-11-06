package com.ibracero.postapp.presentation.di.components;

import android.app.Application;

import com.ibracero.postapp.presentation.di.modules.ActivityModule;
import com.ibracero.postapp.presentation.di.modules.AppModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = AppModule.class)
public interface AppComponent {

    Application app();

    ActivityComponent plus(ActivityModule activityModule);

}
