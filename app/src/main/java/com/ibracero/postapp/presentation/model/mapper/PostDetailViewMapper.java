package com.ibracero.postapp.presentation.model.mapper;

import com.ibracero.postapp.Constants;
import com.ibracero.postapp.domain.model.PostModel;
import com.ibracero.postapp.domain.model.mapper.Mapper;
import com.ibracero.postapp.presentation.model.PostDetailViewModel;

import javax.inject.Inject;

public class PostDetailViewMapper extends Mapper<PostModel, PostDetailViewModel> {

    @Inject
    public PostDetailViewMapper() {
    }

    @Override
    protected PostDetailViewModel transform(PostModel model) {
        return new PostDetailViewModel.Builder()
                .postTitle(model.getTitle() != null
                        ? model.getTitle()
                        : "")
                .postBody(model.getBody() != null
                        ? model.getBody()
                        : "")
                .writerName(model.getWriter() != null
                        ? model.getWriter().getUsername()
                        : "")
                .writerImageUrl(model.getWriter() != null
                        ? Constants.IMAGE_GENERATOR_URL + model.getWriter().getEmail()
                        : "")
                .commentCounter(model.getComments() != null
                        ? String.valueOf(model.getComments().size())
                        : "")
                .build();
    }

    @Override
    protected PostModel untransform(PostDetailViewModel model) {
        return null;
    }
}
