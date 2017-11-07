package com.ibracero.postapp.domain.use_case;

import java.util.HashSet;
import java.util.Set;

import io.reactivex.Scheduler;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;


public abstract class UseCase<T> {

    protected final Scheduler scheduler;
    protected final Scheduler postExecutionScheduler;
    protected Set<Disposable> subscriptions = new HashSet<>();

    protected UseCase(Scheduler scheduler,
                      Scheduler postExecutionScheduler) {
        this.scheduler = scheduler;
        this.postExecutionScheduler = postExecutionScheduler;
    }


    public Disposable execute(SingleObserver<T> singleObserver) {
        this.subscriptions.add((Disposable) getSingle().subscribeWith(singleObserver));
        return getSubscription();
    }

    public Single<T> getSingle() {
        return buildSingle()
                .subscribeOn(scheduler)
                .observeOn(postExecutionScheduler);
    }

    public Disposable getSubscription() {
        return new CompositeDisposable(subscriptions.toArray(new Disposable[subscriptions.size()]));
    }

    public void dispose() {
        this.getSubscription().dispose();
    }

    protected abstract Single<T> buildSingle();


}