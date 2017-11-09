package com.ibracero.postapp.presentation.ui.post_list;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.babylonhealth.babylonpost.R;
import com.ibracero.postapp.presentation.di.components.ActivityComponent;
import com.ibracero.postapp.presentation.model.PostViewModel;
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

    @Inject
    PostAdapter mPostAdapter;

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

        setupRecyclerView();

        mPresenter.setView(this);
        mPresenter.onStart();
    }

    private void setupRecyclerView() {
        mRvPosts.setLayoutManager(new LinearLayoutManager(getActivity()));
    }

    @Override
    public void showErrorMessage(String message) {
        mErrorNotificator.showMessage(message);
    }

    @Override
    public void showPosts(List<PostViewModel> postViewModels) {
        mPostAdapter.setDataset(postViewModels);
        mRvPosts.setAdapter(mPostAdapter);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mPresenter.onDestroy();
    }
}
