package com.ibracero.postapp.presentation.model.mapper;

import com.ibracero.postapp.Constants;
import com.ibracero.postapp.domain.model.PostModel;
import com.ibracero.postapp.domain.model.mapper.Mapper;
import com.ibracero.postapp.presentation.model.PostItemViewModel;

import javax.inject.Inject;

public class PostViewMapper extends Mapper<PostModel, PostItemViewModel> {

    @Inject
    public PostViewMapper() {
    }

    @Override
    protected PostItemViewModel transform(PostModel model) {
        return new PostItemViewModel.Builder()
                .id(model.getId())
                .title(model.getTitle())
                .writerImage(model.getWriter() != null
                        ? Constants.IMAGE_GENERATOR_URL + model.getWriter().getEmail()
                        : "")
                .build();
    }

    @Override
    protected PostModel untransform(PostItemViewModel model) {
        return new PostModel.Builder()
                .id(model.getId())
                .title(model.getTitle())
                .build();
    }
}
