package com.ibracero.postapp.presentation.navigator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;

import com.ibracero.postapp.domain.model.PostModel;
import com.ibracero.postapp.presentation.ui.detail.DetailActivity;

import javax.inject.Inject;

public class Navigator {

    private final AppCompatActivity mActivity;

    @Inject
    public Navigator(AppCompatActivity activity) {
        mActivity = activity;
    }

    public void navigateToDetail(PostModel postModel) {
        Intent detail = new Intent(mActivity, DetailActivity.class);
        detail.putExtra(DetailActivity.POST_EXTRA, postModel);
        mActivity.startActivity(detail);
    }
}
