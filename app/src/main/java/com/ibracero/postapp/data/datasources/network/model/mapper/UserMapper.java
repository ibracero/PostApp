package com.ibracero.postapp.data.datasources.network.model.mapper;

import com.ibracero.postapp.data.datasources.network.model.ApiUser;
import com.ibracero.postapp.domain.model.UserModel;
import com.ibracero.postapp.domain.model.mapper.Mapper;

import javax.inject.Inject;

public class UserMapper extends Mapper<ApiUser, UserModel> {

    @Inject
    public UserMapper() {
    }

    @Override
    protected UserModel transform(ApiUser model) {
        return new UserModel.Builder()
                .id(model.getId())
                .email(model.getEmail())
                .username(model.getUsername())
                .build();
    }

    @Override
    protected ApiUser untransform(UserModel model) {
        return null;
    }
}
