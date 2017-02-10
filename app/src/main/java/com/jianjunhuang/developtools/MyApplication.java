package com.jianjunhuang.developtools;

import android.app.Application;

import com.jianjunhuang.developtools.framework.BaseToast;
import com.jianjunhuang.developtools.utils.StoreInfo;

/**
 * @author jianjunhuang.me@foxmail.com
 * @since 2017/2/10.
 */

public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        BaseToast.init(this);
        StoreInfo.init(this);
    }
}
