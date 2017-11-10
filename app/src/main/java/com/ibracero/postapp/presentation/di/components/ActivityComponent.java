package com.ibracero.postapp.presentation.di.components;

import com.ibracero.postapp.presentation.di.modules.ActivityModule;
import com.ibracero.postapp.presentation.di.qualifiers.PerActivity;
import com.ibracero.postapp.presentation.ui.base.BaseActivity;
import com.ibracero.postapp.presentation.ui.base.BaseFragment;
import com.ibracero.postapp.presentation.ui.detail.PostDetailFragment;
import com.ibracero.postapp.presentation.ui.post_list.MainActivity;
import com.ibracero.postapp.presentation.ui.post_list.PostListFragment;

import dagger.Subcomponent;

@PerActivity
@Subcomponent(modules = ActivityModule.class)
public interface ActivityComponent {

    void inject(BaseActivity baseActivity);

    void inject(MainActivity activity);

    void inject(BaseFragment baseFragment);

    void inject(PostListFragment fragment);

    void inject(PostDetailFragment fragment);
}
