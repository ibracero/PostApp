package com.ibracero.postapp;

import android.app.Application;

import com.ibracero.postapp.presentation.di.components.AppComponent;
import com.ibracero.postapp.presentation.di.components.DaggerAppComponent;
import com.ibracero.postapp.presentation.di.modules.AppModule;

public class PostApp extends Application {

    private AppComponent mAppComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        this.initializeInjector();
    }

    private void initializeInjector() {
        mAppComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .build();
    }

    public AppComponent getAppComponent() {
        return mAppComponent;
    }
}