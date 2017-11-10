package com.ibracero.postapp.data.datasources.network.model.mapper;

import com.ibracero.postapp.data.datasources.network.model.ApiComment;
import com.ibracero.postapp.domain.model.CommentModel;
import com.ibracero.postapp.domain.model.mapper.Mapper;

public class CommentMapper extends Mapper<ApiComment, CommentModel> {
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
