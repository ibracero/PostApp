package com.ibracero.postapp.presentation;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ProgressBar;

import com.babylonhealth.babylonpost.R;
import com.ibracero.postapp.BaseApp;
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

    @BindView(R.id.pb_loading)
    ProgressBar pbProgress;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setupContentView();
        setupComponent();
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
        return ((BaseApp) getApplication()).getAppComponent();
    }

    protected abstract int getLayoutId();

    protected abstract void createActivity(Bundle savedInstanceState);

    public void showLoading() {
        pbProgress.setVisibility(View.VISIBLE);
    }

    public void hideLoading() {
        if (pbProgress != null) {
            pbProgress.setVisibility(View.GONE);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }
}

