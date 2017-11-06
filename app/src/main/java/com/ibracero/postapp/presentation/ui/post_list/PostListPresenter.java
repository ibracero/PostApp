package com.ibracero.postapp.presentation.ui.post_list;

import com.ibracero.postapp.presentation.di.qualifiers.PerActivity;
import com.ibracero.postapp.presentation.navigator.PostListNavigator;
import com.ibracero.postapp.presentation.ui.base.BasePresenter;

import javax.inject.Inject;

@PerActivity
public class PostListPresenter extends BasePresenter<PostListViewInterface> {

    private final PostListNavigator mNavigator;
    private PostListViewInterface mView;

    @Inject
    public PostListPresenter(PostListNavigator navigator) {
        mNavigator = navigator;
    }

    @Override
    public void setView(PostListViewInterface view) {
        mView = view;
    }

    @Override
    public void onStart() {

    }

    @Override
    public void onDestroy() {

    }

    public void onPostClicked() {
        mNavigator.navigateToDetail(1);
    }
}
