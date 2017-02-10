package com.jianjunhuang.developtools;

import android.os.Build;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;

/**
 * 1. 添加 initView 、initListener
 * @author jianjunhuang.me@foxmail.com
 * @since 2017/2/10.
 */

public abstract class BaseActivity extends AppCompatActivity {

    /**
     * 初始化 ui
     */
    protected abstract void initView();

    /**
     * 初始化 listener
     */
    protected abstract void initListener();

    /**
     * 沉浸式标签 默认开启
     */
    private boolean isSetStatusBar = true;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(isSetStatusBar){
            steepStatusBar();
        }
    }

    /**
     * 开启沉浸式
     */
    private void steepStatusBar(){
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT){
            //透明状态栏
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            //透明导航栏
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        }
    }

    /**
     * 设置沉浸式（默认开启）
     * @param isSetStatusBar 默认 true
     */
    protected void setSteepStatuBar(boolean isSetStatusBar){
        this.isSetStatusBar = isSetStatusBar;
    }

    /**
     *
     * 实例化 view ，不用再强制转换
     *
     * @param id
     * @param <T>
     * @return
     */
    protected <T extends View> T findView(int id){
        View view = findViewById(id);
        return (T)view;
    }

}
