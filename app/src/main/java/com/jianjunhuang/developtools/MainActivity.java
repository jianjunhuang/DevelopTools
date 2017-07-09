package com.jianjunhuang.developtools;

import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.demo.jianjunhuang.mvptools.utils.NetworkUtils;
import com.demo.jianjunhuang.mvptools.utils.ToastUtils;

/**
 * @author jianjunhuang.me@foxmail.com
 *         create on 2017/7/6.
 */

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button toastShowBtn;
    private Button toastStyleBtn;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initListener();
        this.registerReceiver(new NetworkReceiver(),new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION));
    }

    private void initListener() {
        toastShowBtn.setOnClickListener(this);
        toastStyleBtn.setOnClickListener(this);
    }

    private void initView() {
        toastShowBtn = (Button) findViewById(R.id.toast_show_btn);
        toastStyleBtn = (Button) findViewById(R.id.internet_status_btn);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.toast_show_btn: {
                ToastUtils.show(R.id.toast_tv, "test");
                break;
            }
            case R.id.internet_status_btn: {

                int i = NetworkUtils.getNetworkStatus();

                String str="";
                switch (i) {
                    case ConnectivityManager.TYPE_WIFI: {
                        str = "WIFI";
                        break;
                    }
                    case ConnectivityManager.TYPE_MOBILE: {
                        str = "MOBILE";
                        break;
                    }
                    case ConnectivityManager.TYPE_MOBILE_DUN: {
                        str = "MOBILE_DUN";
                        break;
                    }
                    case ConnectivityManager.TYPE_VPN: {
                        str = "VPN";
                        break;
                    }
                    case ConnectivityManager.TYPE_WIMAX: {
                        str = "WIMAX";
                        break;
                    }
                }
                toastStyleBtn.setText(str);
                break;
            }
        }
    }
}
