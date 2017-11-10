package com.ibracero.postapp.data.di.modules;

import com.ibracero.postapp.data.datasources.network.model.mapper.CommentMapper;
import com.ibracero.postapp.data.datasources.network.model.mapper.PostMapper;
import com.ibracero.postapp.data.datasources.network.model.mapper.UserMapper;

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

    @Singleton
    @Provides
    public CommentMapper provideCommentMapper() {
        return new CommentMapper();
    }

    @Singleton
    @Provides
    public UserMapper provideUserMapper() {
        return new UserMapper();
    }



}
