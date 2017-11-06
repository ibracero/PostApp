package com.ibracero.postapp.presentation.ui.post_list;

import android.os.Bundle;

import com.babylonhealth.babylonpost.R;
import com.ibracero.postapp.presentation.ui.base.BaseActivity;

public class MainActivity extends BaseActivity {

    @Override
    protected int getToolbarTitle() {
        return R.string.toolbar_title_list;
    }

    @Override
    protected void createActivity(Bundle savedInstanceState) {
        PostListFragment fragment = PostListFragment.newInstance();
        getSupportFragmentManager().beginTransaction().replace(R.id.fl_base_container, fragment).commit();
    }
}
