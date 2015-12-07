package com.mobile.pushalarm.app;

/**
 * Created by jpratik on 10/17/15.
 */
import android.app.Application;

import com.mobile.pushalarm.helper.ParseUtils;

public class MyApplication extends Application {

    private static MyApplication mInstance;

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;

        // register with parse
        ParseUtils.registerParse(this);
    }


    public static synchronized MyApplication getInstance() {
        return mInstance;
    }
}