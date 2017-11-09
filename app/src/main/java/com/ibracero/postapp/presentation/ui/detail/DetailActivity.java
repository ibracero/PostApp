package com.ibracero.postapp.presentation.ui.detail;

import android.os.Bundle;

import com.babylonhealth.babylonpost.R;
import com.ibracero.postapp.presentation.ui.base.BaseActivity;
import com.ibracero.postapp.presentation.ui.post_list.PostListFragment;

public class DetailActivity extends BaseActivity {

    public static String POST_ID_EXTRA = "post_id_extra";

    @Override
    protected int getToolbarTitle() {
        return R.string.toolbar_title_detail;
    }

    @Override
    protected void createActivity(Bundle savedInstanceState) {

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        PostDetailFragment fragment = PostDetailFragment.newInstance();
        getSupportFragmentManager().beginTransaction().replace(R.id.fl_base_container, fragment).commit();
    }
}
