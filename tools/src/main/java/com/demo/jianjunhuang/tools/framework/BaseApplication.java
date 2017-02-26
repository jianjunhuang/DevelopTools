package com.demo.jianjunhuang.tools.framework;

import android.app.Application;
import com.demo.jianjunhuang.tools.utils.StoreInfo;

/**
 * @author jianjunhuang.me@foxmail.com
 * @since 2017/2/21.
 */

public class BaseApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        initJpush();
    }

    private void initJpush() {
        //JAnalyticsInterface.init(this);
        BaseToast.init(this);
        StoreInfo.init(this);
        //JAnalyticsInterface.setDebugMode(true);
    }


}
