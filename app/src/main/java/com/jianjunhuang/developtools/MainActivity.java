package com.jianjunhuang.developtools;

import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.demo.jianjunhuang.mvptools.adapter.RecyclerAdapter;
import com.demo.jianjunhuang.mvptools.adapter.RecyclerViewHolder;
import com.demo.jianjunhuang.mvptools.utils.NetworkUtils;
import com.demo.jianjunhuang.mvptools.utils.ToastUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jianjunhuang.me@foxmail.com
 *         create on 2017/7/6.
 */

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button toastShowBtn;
    private Button toastStyleBtn;

    private RecyclerView recyclerView;

    private static final String TAG = "MainActivity";

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initListener();
        this.registerReceiver(new NetworkReceiver(), new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION));
    }

    private void initListener() {
        toastShowBtn.setOnClickListener(this);
        toastStyleBtn.setOnClickListener(this);
    }

    private void initView() {
        toastShowBtn = (Button) findViewById(R.id.toast_show_btn);
        toastStyleBtn = (Button) findViewById(R.id.internet_status_btn);
        recyclerView = (RecyclerView) findViewById(R.id.show_rv);

        initRecyclerView();
    }

    private List<String> getData() {
        List<String> datas = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            datas.add(i + "");
//            Log.i(TAG, "getData: " + i);
        }
        return datas;
    }

    private void initRecyclerView() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayout.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        List<String> datas = getData();
        recyclerView.setAdapter(new RecyclerAdapter<String>(this, datas, R.layout.item_layout) {
            @Override
            public void convert(RecyclerViewHolder viewHolder, String s) {
                viewHolder.setText(R.id.rv_text_tv, s);
            }
        });
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

                String str = "";
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
