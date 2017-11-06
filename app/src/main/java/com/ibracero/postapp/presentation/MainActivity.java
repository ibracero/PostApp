package com.ibracero.postapp.presentation;

import android.os.Bundle;

import com.babylonhealth.babylonpost.R;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
    }

    @Override
    protected int getLayoutId() {
        return 0;
    }

    @Override
    protected void createActivity(Bundle savedInstanceState) {

    }
}
