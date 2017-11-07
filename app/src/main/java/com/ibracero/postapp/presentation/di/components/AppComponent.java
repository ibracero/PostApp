package com.ibracero.postapp.presentation.di.components;

import android.app.Application;

import com.ibracero.postapp.data.di.modules.DataModule;
import com.ibracero.postapp.data.di.modules.RepositoryModule;
import com.ibracero.postapp.data.di.modules.RetrofitModule;
import com.ibracero.postapp.presentation.di.modules.ActivityModule;
import com.ibracero.postapp.presentation.di.modules.AppModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {AppModule.class,
        RepositoryModule.class,
        DataModule.class,
        RetrofitModule.class})
public interface AppComponent {

    Application app();

    ActivityComponent plus(ActivityModule activityModule);

}
