package com.ibracero.postapp.presentation.ui.error;

import android.app.Activity;
import android.view.Gravity;
import android.widget.TextView;
import android.widget.Toast;

import com.ibracero.postapp.domain.log.Logger;

public class ToastNotificator implements Notificator {

    private Activity mActivity;
    private Toast mToast;
    private Logger mLogger;

    public ToastNotificator(Activity context, Logger logger) {
        mActivity = context;
        mLogger = logger;
    }

    @Override
    public void showMessage(String msg) {
        try {
            if (mToast != null)
                mToast.cancel();

            mToast = Toast.makeText(mActivity, msg, Toast.LENGTH_SHORT);

            TextView v = (TextView) mToast.getView().findViewById(android.R.id.message);
            if (v != null) v.setGravity(Gravity.CENTER);

            if (mActivity != null && !mActivity.isFinishing()) {
                mToast.show();
            }
        } catch (Exception e) {
            mLogger.e(this.getClass().getSimpleName(), "Couldn't show msg", e);
        }
    }
}
