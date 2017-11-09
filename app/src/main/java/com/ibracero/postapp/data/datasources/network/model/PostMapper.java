package com.ibracero.postapp.data.datasources.network.model;

import com.ibracero.postapp.domain.model.PostModel;
import com.ibracero.postapp.domain.model.mapper.Mapper;

import javax.inject.Inject;

public class PostMapper extends Mapper<ApiPost, PostModel> {

    @Inject
    public PostMapper() {
    }

    @Override
    protected PostModel transform(ApiPost model) {
        return new PostModel.Builder()
                .id(model.getId())
                .userId(model.getUserId())
                .body(model.getBody())
                .title(model.getTitle())
                .build();
    }

    @Override
    protected ApiPost untransform(PostModel model) {
        return null;
    }
}
