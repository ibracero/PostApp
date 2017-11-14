package com.ibracero.postapp.data.repository;

import com.ibracero.postapp.data.datasources.network.WebServicesApi;
import com.ibracero.postapp.data.datasources.network.model.mapper.UserMapper;
import com.ibracero.postapp.domain.model.UserModel;
import com.ibracero.postapp.domain.repository.UserRepository;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Single;


public class UserRepositoryImpl implements UserRepository {

    private final WebServicesApi mWebServicesApi;
    private final UserMapper mUserMapper;

    @Inject
    public UserRepositoryImpl(WebServicesApi webServicesApi,
                              UserMapper userMapper) {

        mWebServicesApi = webServicesApi;
        mUserMapper = userMapper;
    }

    @Override
    public Single<List<UserModel>> getUsers() {
        return mWebServicesApi.getUsers().map(mUserMapper::map);
    }
}
