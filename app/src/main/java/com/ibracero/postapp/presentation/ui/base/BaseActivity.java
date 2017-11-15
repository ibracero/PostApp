package com.ibracero.postapp.presentation.ui.base;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ProgressBar;

import com.ibracero.postapp.PostApp;
import com.ibracero.postapp.R;
import com.ibracero.postapp.presentation.di.components.ActivityComponent;
import com.ibracero.postapp.presentation.di.components.AppComponent;
import com.ibracero.postapp.presentation.di.modules.ActivityModule;
import com.ibracero.postapp.presentation.di.qualifiers.HasComponent;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public abstract class BaseActivity extends AppCompatActivity implements HasComponent<ActivityComponent> {

    protected ActivityComponent mActivityComponent;

    private Unbinder unbinder;

    @BindView(R.id.toolbar)
    Toolbar mToolbar;

    @BindView(R.id.pb_loading)
    ProgressBar mPbLoading;

    @BindView(R.id.fl_base_container)
    FrameLayout mBaseContainer;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setupContentView();
        setupToolbar();
        setupComponent();
        createActivity(savedInstanceState);
    }

    private void setupToolbar() {
        mToolbar.setTitle(getToolbarTitle());
        setSupportActionBar(mToolbar);
    }

    private void setupContentView() {
        setContentView(R.layout.activity_base);
        unbinder = ButterKnife.bind(this);
    }

    private void setupComponent() {
        mActivityComponent = getApplicationComponent()
                .plus(getActivityModule());

        mActivityComponent.inject(this);
    }


    protected ActivityModule getActivityModule() {
        return new ActivityModule(this);
    }

    @Override
    public ActivityComponent getComponent() {
        return mActivityComponent;
    }

    protected AppComponent getApplicationComponent() {
        return ((PostApp) getApplication()).getAppComponent();
    }

    protected abstract int getToolbarTitle();

    protected abstract void createActivity(Bundle savedInstanceState);

    public void showLoading() {
        mPbLoading.setVisibility(View.VISIBLE);
    }

    public void hideLoading() {
        if (mPbLoading != null) {
            mPbLoading.setVisibility(View.GONE);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }

    @Override
    public void startActivity(Intent intent) {
        super.startActivity(intent);
        overridePendingTransition(R.anim.animation_enter_right, R.anim.animation_leave_right);
    }


    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.animation_enter_left, R.anim.animation_leave_left);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

}

