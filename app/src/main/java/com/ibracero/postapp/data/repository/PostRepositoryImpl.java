package com.ibracero.postapp.data.repository;

import com.ibracero.postapp.data.datasources.network.WebServicesApi;
import com.ibracero.postapp.data.datasources.network.model.mapper.CommentMapper;
import com.ibracero.postapp.data.datasources.network.model.mapper.PostMapper;
import com.ibracero.postapp.data.datasources.network.model.mapper.UserMapper;
import com.ibracero.postapp.domain.model.CommentModel;
import com.ibracero.postapp.domain.model.PostModel;
import com.ibracero.postapp.domain.model.UserModel;
import com.ibracero.postapp.domain.repository.PostRepository;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Single;

public class PostRepositoryImpl implements PostRepository {

    private final WebServicesApi mWebServicesApi;
    private final PostMapper mPostMapper;
    private final CommentMapper mCommentMapper;
    private final UserMapper mUserMapper;

    @Inject
    public PostRepositoryImpl(WebServicesApi webServicesApi,
                              PostMapper postMapper,
                              CommentMapper commentMapper,
                              UserMapper userMapper) {
        mWebServicesApi = webServicesApi;
        mPostMapper = postMapper;
        mCommentMapper = commentMapper;
        mUserMapper = userMapper;
    }

    @Override
    public Single<List<PostModel>> getPosts() {
        return mWebServicesApi.getPosts().map(mPostMapper::map);
    }

    @Override
    public Single<List<CommentModel>> getComments() {
        return mWebServicesApi.getComments().map(mCommentMapper::map);
    }

    @Override
    public Single<List<UserModel>> getUsers() {
        return mWebServicesApi.getUsers().map(mUserMapper::map);
    }

    @Override
    public Single<PostModel> getPostInfo(int postId) {
        return mWebServicesApi.getPostInfo(postId);
    }
}
