package com.ibracero.postapp.presentation.model.mapper;

import com.ibracero.postapp.domain.model.PostModel;
import com.ibracero.postapp.domain.model.mapper.Mapper;
import com.ibracero.postapp.presentation.model.PostViewModel;

import javax.inject.Inject;

public class PostViewMapper extends Mapper<PostModel, PostViewModel> {

    @Inject
    public PostViewMapper() {
    }

    @Override
    protected PostViewModel transform(PostModel model) {
        return new PostViewModel.Builder()
                .id(model.getId())
                .title(model.getTitle())
                .build();
    }

    @Override
    protected PostModel untransform(PostViewModel model) {
        return new PostModel.Builder()
                .id(model.getId())
                .title(model.getTitle())
                .build();
    }
}
