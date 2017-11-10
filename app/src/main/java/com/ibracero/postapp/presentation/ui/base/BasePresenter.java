package com.ibracero.postapp.presentation.ui.base;

public abstract class BasePresenter<V> {

    private static final String TAG = BasePresenter.class.getSimpleName();

    public abstract void setView(V view);

    public abstract void onStart();

    public abstract void onDestroy();

}