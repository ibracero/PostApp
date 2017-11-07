package com.ibracero.postapp.presentation.ui.post_list;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.babylonhealth.babylonpost.R;
import com.ibracero.postapp.domain.model.Post;
import com.ibracero.postapp.presentation.di.components.ActivityComponent;
import com.ibracero.postapp.presentation.ui.base.BaseFragment;
import com.ibracero.postapp.presentation.ui.error.ErrorNotificator;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;

public class PostListFragment extends BaseFragment implements PostListViewInterface {


    @BindView(R.id.rv_posts)
    RecyclerView mRvPosts;

    @Inject
    PostListPresenter mPresenter;

    @Inject
    ErrorNotificator mErrorNotificator;

    public static PostListFragment newInstance() {
        PostListFragment fragment = new PostListFragment();
        return fragment;
    }

    @Override
    protected int getFragmentLayout() {
        return R.layout.fragment_post_list;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        this.getComponent(ActivityComponent.class).inject(this);
        mPresenter.setView(this);
        mPresenter.onStart();
    }

    @Override
    public void showErrorMessage(String message) {
        mErrorNotificator.showMessage(message);
    }

    @Override
    public void showPosts(List<Post> posts) {
        mErrorNotificator.showMessage(posts != null ? String.valueOf(posts.size()) : "0");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mPresenter.onDestroy();
    }
}
