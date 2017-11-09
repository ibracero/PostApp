package com.ibracero.postapp.data.di.modules;

import com.ibracero.postapp.data.datasources.network.model.PostMapper;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class DataMapperModule {

    @Singleton
    @Provides
    public PostMapper providePostMapper() {
        return new PostMapper();
    }

}
