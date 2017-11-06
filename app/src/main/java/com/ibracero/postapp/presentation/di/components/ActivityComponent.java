package com.ibracero.postapp.presentation.di.components;

import com.ibracero.postapp.presentation.BaseActivity;
import com.ibracero.postapp.presentation.MainActivity;
import com.ibracero.postapp.presentation.di.modules.ActivityModule;
import com.ibracero.postapp.presentation.di.qualifiers.PerActivity;

import dagger.Subcomponent;

@PerActivity
@Subcomponent(modules = ActivityModule.class)
public interface ActivityComponent {

    void inject(BaseActivity baseActivity);

    void inject(MainActivity activity);
}
