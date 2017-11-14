package com.ibracero.postapp.domain.use_case.comments;

import com.ibracero.postapp.domain.model.PostModel;
import com.ibracero.postapp.domain.model.UserModel;
import com.ibracero.postapp.domain.repository.PostRepository;
import com.ibracero.postapp.domain.repository.UserRepository;
import com.ibracero.postapp.domain.use_case.UseCase;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import io.reactivex.Scheduler;
import io.reactivex.Single;

public class GetPostsUseCase extends UseCase<List<PostModel>> {

    private final PostRepository mPostRepository;
    private final UserRepository mUserRepository;

    @Inject
    public GetPostsUseCase(@Named("io") Scheduler scheduler,
                           @Named("main") Scheduler postExecutionScheduler,
                           PostRepository postRepository,
                           UserRepository userRepository) {
        super(scheduler, postExecutionScheduler);

        mPostRepository = postRepository;
        mUserRepository = userRepository;
    }

    @Override
    protected Single<List<PostModel>> buildSingle() {
        return mPostRepository.getPosts()
                .zipWith(mUserRepository.getUsers(), (postModels, userModels) -> {
                    for (PostModel postModel : postModels) {
                        for (UserModel userModel : userModels) {
                            if (postModel.getUserId() == userModel.getId()) {
                                postModel.setWriter(userModel);
                            }
                        }
                    }
                    return postModels;
                });

    }
}
