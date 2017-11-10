package com.ibracero.postapp.presentation.di.components;

import android.app.Application;

import com.ibracero.postapp.data.di.modules.DataMapperModule;
import com.ibracero.postapp.data.di.modules.RepositoryModule;
import com.ibracero.postapp.data.di.modules.RetrofitModule;
import com.ibracero.postapp.presentation.di.modules.ActivityModule;
import com.ibracero.postapp.presentation.di.modules.AppModule;
import com.ibracero.postapp.presentation.di.modules.PresentationMapperModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {AppModule.class,
        RepositoryModule.class,
        DataMapperModule.class,
        PresentationMapperModule.class,
        RetrofitModule.class})
public interface AppComponent {

    Application app();

    ActivityComponent plus(ActivityModule activityModule);

}
