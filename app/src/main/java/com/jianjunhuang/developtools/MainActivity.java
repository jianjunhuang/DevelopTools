package com.jianjunhuang.developtools;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.jianjunhuang.developtools.framework.BaseActivity;
import com.jianjunhuang.developtools.framework.BaseToast;

public class MainActivity extends BaseActivity implements View.OnClickListener{

    private Button show_short_btn;
    private Button show_long_btn;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setSteepStatuBar(false);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        show_long_btn = findView(R.id.show_long_btn);
        show_short_btn = findView(R.id.show_short_btn);
    }

    @Override
    protected void initListener() {
        show_long_btn.setOnClickListener(this);
        show_short_btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.show_long_btn:
                BaseToast.showLong("long");
                Log.i("tag","long");
                break;
            case R.id.show_short_btn:
                BaseToast.showShort("short");
                Log.i("tag","long");
                break;
        }
    }
}
