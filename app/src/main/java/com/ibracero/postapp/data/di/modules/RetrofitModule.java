package com.ibracero.postapp.data.di.modules;

import com.babylonhealth.babylonpost.BuildConfig;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.ibracero.postapp.data.datasources.network.WebServicesApi;
import com.ibracero.postapp.data.datasources.network.error.ErrorInterceptor;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class RetrofitModule {

    private static final int TIMEOUT = 100;
    private static final long CONNECT_TIMEOUT = 100;


    @Provides
    @Singleton
    public Gson provideGson() {
        return new GsonBuilder()
                .setPrettyPrinting()
                .disableHtmlEscaping()
                .create();
    }

    @Provides
    @Singleton
    HttpLoggingInterceptor provideHttpLoggingInterceptor() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        return interceptor;
    }


    @Provides
    @Singleton
    public OkHttpClient provideOkHttpClient(ErrorInterceptor errorInterceptor, HttpLoggingInterceptor loggingInterceptor) {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();

        builder.addInterceptor(errorInterceptor)
                .connectTimeout(CONNECT_TIMEOUT, TimeUnit.SECONDS)
                .readTimeout(TIMEOUT, TimeUnit.SECONDS)
                .writeTimeout(TIMEOUT, TimeUnit.SECONDS)
                .addInterceptor(loggingInterceptor);

        return builder.build();
    }

    @Provides
    @Singleton
    public Retrofit provideRetrofit(Gson gson, OkHttpClient okHttpClient) {
        return new Retrofit.Builder()
                .baseUrl(BuildConfig.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(okHttpClient)
                .build();
    }

    @Provides
    @Singleton
    public WebServicesApi provideWebServicesApi(Retrofit retrofit) {
        return retrofit.create(WebServicesApi.class);
    }

}