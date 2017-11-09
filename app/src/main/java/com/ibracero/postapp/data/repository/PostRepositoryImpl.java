package com.ibracero.postapp.data.repository;

import com.ibracero.postapp.data.datasources.network.WebServicesApi;
import com.ibracero.postapp.data.datasources.network.model.PostMapper;
import com.ibracero.postapp.domain.model.PostModel;
import com.ibracero.postapp.domain.repository.PostRepository;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Single;

public class PostRepositoryImpl implements PostRepository {

    private final WebServicesApi mWebServicesApi;
    private final PostMapper mPostMapper;

    @Inject
    public PostRepositoryImpl(WebServicesApi webServicesApi,
                              PostMapper postMapper) {
        mWebServicesApi = webServicesApi;
        mPostMapper = postMapper;
    }

    @Override
    public Single<List<PostModel>> getPosts() {
        return mWebServicesApi.getPosts().map(mPostMapper::map);
    }
}
