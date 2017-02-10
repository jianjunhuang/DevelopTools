package com.jianjunhuang.developtools.framework;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Fragment 的基类
 * 1.findView
 * 2.Toast
 *
 * @author jianjunhuang.me@foxmail.com
 * @since 2017/2/10.
 */

public abstract class BaseFragment extends Fragment {

    private View view;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        view = inflater.inflate(getLayoutId(), container, false);

        return view;

    }

    protected abstract int getLayoutId();

    protected abstract void initView(View view);

    protected abstract void initListener();

    protected <T extends View> T findView(int id) {
        View v = view.findViewById(id);
        return (T) v;
    }

    public static void showShort(String msg) {
        BaseToast.showShort(msg);
    }

    public static void showLong(String msg) {
        BaseToast.showLong(msg);
    }

    public static void showShort(int msg) {
        BaseToast.showShort(msg);
    }

    public static void showLong(int msg) {
        BaseToast.showLong(msg);
    }
}
