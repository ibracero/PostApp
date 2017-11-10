package com.ibracero.postapp.presentation.di.modules;

import com.ibracero.postapp.presentation.model.mapper.PostItemViewMapper;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class PresentationMapperModule {

    @Singleton
    @Provides
    public PostItemViewMapper providePostMapper() {
        return new PostItemViewMapper();
    }

}