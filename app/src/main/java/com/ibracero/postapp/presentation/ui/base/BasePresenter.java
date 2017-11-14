package com.ibracero.postapp.presentation.ui.base;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

public abstract class BasePresenter<V> {

    private CompositeDisposable mCompositeDisposable;

    protected V mView;

    public void attachView(V view) {
        mView = view;
        mCompositeDisposable = new CompositeDisposable();
    }

    protected abstract void onStart();

    protected void addDisposable(Disposable disposable) {
        mCompositeDisposable.add(disposable);
    }

    public void detachView() {
        if (mCompositeDisposable != null
                && !mCompositeDisposable.isDisposed()) {
            mCompositeDisposable.dispose();
        }
        mView = null;
    }

}