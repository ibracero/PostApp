package com.ibracero.postapp.data.repository;

import com.ibracero.postapp.data.datasources.network.WebServicesApi;
import com.ibracero.postapp.data.datasources.network.model.mapper.CommentMapper;
import com.ibracero.postapp.domain.model.CommentModel;
import com.ibracero.postapp.domain.repository.CommentRepository;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Single;


public class CommentRepositoryImpl implements CommentRepository {

    private final WebServicesApi mWebServicesApi;
    private final CommentMapper mCommentMapper;

    @Inject
    public CommentRepositoryImpl(WebServicesApi webServicesApi,
                                 CommentMapper commentMapper) {
        mWebServicesApi = webServicesApi;
        mCommentMapper = commentMapper;
    }

    @Override
    public Single<List<CommentModel>> getComments() {
        return mWebServicesApi.getComments().map(mCommentMapper::map);
    }
}

