package com.ibracero.postapp.presentation.di.modules;

import android.app.Application;
import android.util.Log;

import com.ibracero.postapp.domain.log.Logger;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

@Module
public class AppModule {

    private final Application application;

    public AppModule(Application application) {
        this.application = application;
    }

    @Provides
    @Singleton
    Application provideApplication() {
        return this.application;
    }


    @Provides
    @Singleton
    @Named("io")
    public Scheduler provideIOScheduler() {
        return Schedulers.io();
    }

    @Provides
    @Singleton
    @Named("main")
    public Scheduler providePostExecutionThread() {
        return AndroidSchedulers.mainThread();
    }


    @Provides
    @Singleton
    public Logger provideLogger() {
        return new Logger() {

            @Override
            public void i(String tag, String message) {
                Log.i(tag, message);
            }

            @Override
            public void v(String tag, String message) {
                Log.d(tag, message);
            }

            @Override
            public void d(String tag, String message) {
                Log.d(tag, message);
            }

            @Override
            public void e(String tag, String message, Throwable error) {
                Log.e(tag, message, error);
            }
        };
    }

}
