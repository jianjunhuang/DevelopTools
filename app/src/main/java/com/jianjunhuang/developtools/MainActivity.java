package com.jianjunhuang.developtools;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

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
    }

    private void initListener() {
        toastShowBtn.setOnClickListener(this);
        toastStyleBtn.setOnClickListener(this);
    }

    private void initView() {
        toastShowBtn = (Button) findViewById(R.id.toast_show_btn);
        toastStyleBtn = (Button) findViewById(R.id.toast_style_btn);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.toast_show_btn: {
                ToastUtils.show(R.id.toast_tv,"test");
                break;
            }
            case R.id.toast_style_btn: {
                break;
            }
        }
    }
}
