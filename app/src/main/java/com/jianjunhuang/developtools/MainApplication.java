package com.jianjunhuang.developtools;

import android.app.Application;

import com.demo.jianjunhuang.mvptools.utils.ToastUtils;

/**
 * @author jianjunhuang.me@foxmail.com
 *         create on 2017/7/6.
 */

public class MainApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        ToastUtils.init(this,R.layout.toast_layout);
    }

}
