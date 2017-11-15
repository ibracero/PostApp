package com.ibracero.postapp.data.datasources.network.model.mapper;

import com.ibracero.postapp.data.datasources.network.model.ApiComment;
import com.ibracero.postapp.domain.model.CommentModel;
import com.ibracero.postapp.domain.model.mapper.Mapper;

import javax.inject.Inject;

public class CommentMapper extends Mapper<ApiComment, CommentModel> {

    @Inject
    public CommentMapper() {
    }

    @Override
    protected CommentModel transform(ApiComment model) {
        return new CommentModel.Builder()
                .postId(model.getPostId())
                .name(model.getName())
                .body(model.getBody())
                .email(model.getEmail())
                .build();
    }

    @Override
    protected ApiComment untransform(CommentModel model) {
        return null;
    }
}
