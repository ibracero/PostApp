package com.ibracero.postapp.data.di.modules;

import com.ibracero.postapp.data.repository.PostRepositoryImpl;
import com.ibracero.postapp.domain.repository.PostRepository;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class RepositoryModule {

    @Provides
    @Singleton
    public PostRepository providePostRepository(PostRepositoryImpl postRepositoryImpl) {
        return postRepositoryImpl;
    }
}
