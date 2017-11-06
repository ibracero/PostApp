package com.ibracero.postapp.presentation.ui.post_list;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.babylonhealth.babylonpost.R;
import com.ibracero.postapp.presentation.di.components.ActivityComponent;
import com.ibracero.postapp.presentation.ui.base.BaseFragment;

import javax.inject.Inject;

import butterknife.OnClick;

public class PostListFragment extends BaseFragment implements PostListViewInterface {

    @Inject
    PostListPresenter mPresenter;

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

    @OnClick(R.id.tv_clickable)
    public void onTextViewClicked(){
        mPresenter.onPostClicked();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mPresenter.onDestroy();
    }
}
