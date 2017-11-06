package com.ibracero.postapp.presentation.di.modules;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;

import com.ibracero.postapp.presentation.di.qualifiers.PerActivity;

import dagger.Module;
import dagger.Provides;

@Module
public class ActivityModule {

    private final AppCompatActivity activity;

    public ActivityModule(AppCompatActivity activity) {
        this.activity = activity;
    }

    @Provides
    @PerActivity
    public AppCompatActivity provideActivity(){
        return this.activity;
    }


}
