package com.ibracero.postapp.presentation.ui.detail;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.babylonhealth.babylonpost.R;
import com.ibracero.postapp.presentation.di.components.ActivityComponent;
import com.ibracero.postapp.presentation.ui.base.BaseFragment;

import javax.inject.Inject;

public class PostDetailFragment extends BaseFragment {

    @Inject
    PostDetailPresenter mPresenter;

    public static PostDetailFragment newInstance() {
        PostDetailFragment fragment = new PostDetailFragment();
        return fragment;
    }

    @Override
    protected int getFragmentLayout() {
        return R.layout.fragment_post_detail;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        this.getComponent(ActivityComponent.class).inject(this);

        mPresenter.setView(this);
        mPresenter.onStart();
    }
}
