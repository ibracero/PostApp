package com.ibracero.postapp.presentation.navigator;

import android.content.Intent;
import android.support.v4.app.Fragment;

public interface NavigationView {

    void navigateTo(Intent intent);

    void navigateTo(Fragment fragment);

}