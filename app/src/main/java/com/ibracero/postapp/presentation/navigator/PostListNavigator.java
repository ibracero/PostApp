package com.ibracero.postapp.presentation.navigator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;

import com.ibracero.postapp.presentation.ui.detail.DetailActivity;

import javax.inject.Inject;

public class PostListNavigator extends BaseNavigator<NavigationView> {

    @Inject
    public PostListNavigator(AppCompatActivity activity) {
        super(activity);
    }

    public void navigateToDetail(int postId) {
        Intent detail = new Intent(mActivity, DetailActivity.class);
        detail.putExtra(DetailActivity.POST_ID_EXTRA, postId);
        navigationView.navigateTo(detail);
    }
}
