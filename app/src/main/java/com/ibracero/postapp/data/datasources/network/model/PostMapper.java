package com.ibracero.postapp.data.datasources.network.model;

import com.ibracero.postapp.domain.model.Post;
import com.ibracero.postapp.domain.model.mapper.Mapper;

import javax.inject.Inject;

public class PostMapper extends Mapper<ApiPost, Post> {

    @Inject
    public PostMapper() {
    }

    @Override
    protected Post transform(ApiPost model) {
        return new Post.Builder()
                .id(model.getId())
                .userId(model.getUserId())
                .body(model.getBody())
                .title(model.getTitle())
                .build();
    }

    @Override
    protected ApiPost untransform(Post model) {
        return null;
    }
}
