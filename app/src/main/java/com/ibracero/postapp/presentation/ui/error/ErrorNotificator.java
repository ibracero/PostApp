package com.ibracero.postapp.presentation.ui.error;

import android.support.annotation.StringRes;

public interface ErrorNotificator {

     void showMessage(@StringRes int message);

     void showMessage(String msg);
}
