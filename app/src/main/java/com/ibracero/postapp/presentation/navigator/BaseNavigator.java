package com.ibracero.postapp.presentation.navigator;

import android.support.v7.app.AppCompatActivity;

public abstract class BaseNavigator<NV> {

    protected final NV navigationView;
    protected final AppCompatActivity mActivity;

    public BaseNavigator(AppCompatActivity activity) {
        this.mActivity = activity;
        try {
            this.navigationView = (NV) activity;
        } catch (ClassCastException e) {
            throw new IllegalStateException("Navigation mActivity must implement the navigation view interface", e);
        }
    }

}