package com.jianjunhuang.developtools;

import android.app.Application;

import com.jianjunhuang.developtools.framework.BaseToast;

/**
 * @author jianjunhuang.me@foxmail.com
 * @since 2017/2/10.
 */

public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        BaseToast.init(this);
    }
}
