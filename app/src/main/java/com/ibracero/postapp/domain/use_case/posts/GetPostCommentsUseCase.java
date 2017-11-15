package com.ibracero.postapp.domain.use_case.posts;

import com.ibracero.postapp.domain.model.CommentModel;
import com.ibracero.postapp.domain.repository.CommentRepository;
import com.ibracero.postapp.domain.use_case.UseCase;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import io.reactivex.Scheduler;
import io.reactivex.Single;

public class GetPostCommentsUseCase extends UseCase<List<CommentModel>> {

    private final CommentRepository mCommentRepository;
    private int mPostId;

    @Inject
    protected GetPostCommentsUseCase(@Named("io") Scheduler scheduler,
                                     @Named("main") Scheduler postExecutionScheduler,
                                     CommentRepository commentRepository) {
        super(scheduler, postExecutionScheduler);
        mCommentRepository = commentRepository;
    }

    @Override
    protected Single<List<CommentModel>> buildSingle() {
        return mCommentRepository.getComments()
                .map(comments -> {
                    List<CommentModel> commentModels = new ArrayList<>();

                    for (CommentModel comment : comments) {
                        if (comment.getPostId() == mPostId) {
                            commentModels.add(comment);
                        }
                    }

                    return commentModels;
                });
    }

    public GetPostCommentsUseCase setPostId(int postId) {
        mPostId = postId;
        return this;
    }
}
