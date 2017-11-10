package com.ibracero.postapp.domain.use_case.posts;

import com.ibracero.postapp.domain.model.CommentModel;
import com.ibracero.postapp.domain.repository.PostRepository;
import com.ibracero.postapp.domain.use_case.UseCase;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import io.reactivex.Scheduler;
import io.reactivex.Single;

public class GetPostComments extends UseCase<List<CommentModel>> {

    private final PostRepository mPostRepository;
    private int mPostId;

    @Inject
    protected GetPostComments(@Named("io") Scheduler scheduler,
                              @Named("main") Scheduler postExecutionScheduler,
                              PostRepository postRepository) {
        super(scheduler, postExecutionScheduler);
        mPostRepository = postRepository;
    }

    @Override
    protected Single<List<CommentModel>> buildSingle() {
        return mPostRepository.getComments()
                .map(comments -> {
                    List<CommentModel> commentModels = new ArrayList<>();

                    for (CommentModel comment : comments) {
                        if (comment.getPostId() == mPostId) {
                            commentModels.add(comment);
                        }
                    }

                    return commentModels;
                })
                .retry();
    }

    public GetPostComments setPostId(int postId) {
        mPostId = postId;
        return this;
    }
}
