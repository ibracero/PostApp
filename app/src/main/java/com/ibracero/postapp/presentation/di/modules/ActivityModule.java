package com.ibracero.postapp.presentation.di.modules;

import android.support.v7.app.AppCompatActivity;

import com.ibracero.postapp.domain.log.Logger;
import com.ibracero.postapp.presentation.di.qualifiers.PerActivity;
import com.ibracero.postapp.presentation.ui.error.ErrorNotificator;
import com.ibracero.postapp.presentation.ui.error.ErrorNotificatorToast;

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
    public AppCompatActivity provideActivity() {
        return this.activity;
    }

    @Provides
    @PerActivity
    ErrorNotificator provideErrorManager(Logger logger) {
        return new ErrorNotificatorToast(activity, logger);
    }

}
