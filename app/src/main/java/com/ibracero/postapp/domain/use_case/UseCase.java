package com.ibracero.postapp.domain.use_case;

import io.reactivex.Scheduler;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;


public abstract class UseCase<T> {

    private final Scheduler scheduler;
    private final Scheduler postExecutionScheduler;

    protected UseCase(Scheduler scheduler,
                      Scheduler postExecutionScheduler) {
        this.scheduler = scheduler;
        this.postExecutionScheduler = postExecutionScheduler;
    }


    public Disposable execute(SingleObserver<T> singleObserver) {
        return (Disposable) getSingle().subscribeWith(singleObserver);
    }

    public Single<T> getSingle() {
        return buildSingle()
                .subscribeOn(scheduler)
                .observeOn(postExecutionScheduler);
    }

    protected abstract Single<T> buildSingle();


}