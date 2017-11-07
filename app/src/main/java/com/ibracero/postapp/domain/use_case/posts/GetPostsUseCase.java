package com.ibracero.postapp.domain.use_case.posts;

import com.ibracero.postapp.domain.model.Post;
import com.ibracero.postapp.domain.repository.PostRepository;
import com.ibracero.postapp.domain.use_case.UseCase;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import io.reactivex.Scheduler;
import io.reactivex.Single;

public class GetPostsUseCase extends UseCase<List<Post>> {

    private final PostRepository mPostRepository;

    @Inject
    public GetPostsUseCase(@Named("io") Scheduler scheduler,
                           @Named("main") Scheduler postExecutionScheduler,
                           PostRepository postRepository) {
        super(scheduler, postExecutionScheduler);

        mPostRepository = postRepository;
    }

    @Override
    protected Single<List<Post>> buildSingle() {
        return mPostRepository.getPosts();
    }
}
