package com.ibracero.postapp.presentation.ui.detail;

import com.ibracero.postapp.presentation.di.qualifiers.PerActivity;
import com.ibracero.postapp.presentation.ui.base.BasePresenter;

import javax.inject.Inject;

@PerActivity
public class PostDetailPresenter extends BasePresenter<PostDetailViewInterface> {

    private int mPostId;
    private PostDetailViewInterface mView;

    @Inject
    public PostDetailPresenter() {
    }

    @Override
    public void setView(PostDetailViewInterface view) {
        mView = view;
    }

    public void setPostId(int postId) {
        mPostId = postId;
    }

    @Override
    public void onStart() {
        getPostInfo(mPostId);
    }

    private void getPostInfo(int postId) {

    }

    @Override
    public void onDestroy() {

    }
}
