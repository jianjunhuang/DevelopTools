package com.jianjunhuang.developtools;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.Log;
import android.widget.Toast;

import com.demo.jianjunhuang.mvptools.utils.NetworkUtils;
import com.demo.jianjunhuang.mvptools.utils.ToastUtils;

/**
 * @author jianjunhuang.me@foxmail.com
 *         create on 2017/7/9.
 */

public class NetworkReceiver extends BroadcastReceiver {

    private static final String TAG = "NetworkReceiver";

    @Override
    public void onReceive(Context context, Intent intent) {
        String intentStr = intent.getAction();
        Log.i(TAG, "onReceive: " + intentStr);

        if (intentStr.equals(ConnectivityManager.CONNECTIVITY_ACTION)) {

            NetworkUtils.setOnNetworkStatus(new NetworkUtils.OnNetworkStatus() {
                @Override
                public void onWifiStatus() {
                    ToastUtils.show("当前正在用 wifi 连接", Toast.LENGTH_LONG);
                }

                @Override
                public void onMobileStatus() {
                    ToastUtils.show("当前正在用流量连接", Toast.LENGTH_SHORT);
                }

                @Override
                public void onNoConnectiveStatus() {
                    ToastUtils.show("当前无法连接网络");
                }
            });
        }
    }
}
