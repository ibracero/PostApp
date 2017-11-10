package com.ibracero.postapp.presentation.ui.detail;

import android.os.Bundle;

import com.ibracero.postapp.R;
import com.ibracero.postapp.domain.model.PostModel;
import com.ibracero.postapp.presentation.ui.base.BaseActivity;

public class DetailActivity extends BaseActivity {

    public static String POST_EXTRA = "post_extra";

    @Override
    protected int getToolbarTitle() {
        return R.string.toolbar_title_detail;
    }

    @Override
    protected void createActivity(Bundle savedInstanceState) {

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        PostDetailFragment fragment = PostDetailFragment.newInstance(getPostExtra());
        getSupportFragmentManager().beginTransaction().replace(R.id.fl_base_container, fragment).commit();
    }

    private PostModel getPostExtra() {

        if (getIntent().getExtras() != null) {
            if (getIntent().getParcelableExtra(POST_EXTRA) != null) {
                return getIntent().getParcelableExtra(POST_EXTRA);
            }
        }

        return null;
    }
}
