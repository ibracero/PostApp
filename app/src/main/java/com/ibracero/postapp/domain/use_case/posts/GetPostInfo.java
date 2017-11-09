package com.ibracero.postapp.domain.use_case.posts;

import com.ibracero.postapp.domain.model.PostModel;
import com.ibracero.postapp.domain.use_case.UseCase;

import javax.inject.Inject;

import io.reactivex.Scheduler;
import io.reactivex.Single;

public class GetPostInfo extends UseCase<PostModel> {

    @Inject
    protected GetPostInfo(Scheduler scheduler, Scheduler postExecutionScheduler) {
        super(scheduler, postExecutionScheduler);
    }

    @Override
    protected Single<PostModel> buildSingle() {
        return null;
    }
}
