package com.ibracero.postapp.data.di.modules;

import com.ibracero.postapp.data.repository.CommentRepositoryImpl;
import com.ibracero.postapp.data.repository.PostRepositoryImpl;
import com.ibracero.postapp.data.repository.UserRepositoryImpl;
import com.ibracero.postapp.domain.repository.CommentRepository;
import com.ibracero.postapp.domain.repository.PostRepository;
import com.ibracero.postapp.domain.repository.UserRepository;

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

    @Provides
    @Singleton
    public CommentRepository provideCommentRepository(CommentRepositoryImpl commentRepositoryImpl) {
        return commentRepositoryImpl;
    }

    @Provides
    @Singleton
    public UserRepository provideUserRepository(UserRepositoryImpl userRepositoryImpl) {
        return userRepositoryImpl;
    }
}
