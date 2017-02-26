package com.demo.jianjunhuang.tools.framework;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Fragment 的基类
 * 1.findView
 * 2.Toast
 * 3.判空
 *
 * @author jianjunhuang.me@foxmail.com
 * @since 2017/2/10.
 */

public abstract class BaseFragment extends Fragment {

  private View view;

  @Override public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    Log.i("fragment", getClass().getSimpleName() + " onCreate");
  }

  @Override public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {

    Log.i("fragment", getClass().getSimpleName() + " onCreateView");
    view = inflater.inflate(getLayoutId(), container, false);
    initView(view);
    initListener();
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

  /**
   * 字符串是否为空
   * @param str string
   * @return true - str is empty or null
   */
  public boolean isEmptyOrNull(String str){
    return str == null || str.equals("");
  }

  /**
   * 跳转 带参数
   *
   * @param clz activity class
   * @param bundle data
   */
  public void startActivity(Class<?> clz, Bundle bundle) {
    Intent intent = new Intent();
    intent.setClass(getActivity(), clz);
    if (bundle != null) {
      intent.putExtras(bundle);
    }
    startActivity(intent);
  }

  /**
   * 跳转 不带参数
   *
   * @param clz activity class
   */
  public void startActivity(Class<?> clz) {
    startActivity(clz, null);
  }

  @Override public void setUserVisibleHint(boolean isVisibleToUser) {
    super.setUserVisibleHint(isVisibleToUser);
    if (!isVisibleToUser) {
      //JAnalyticsInterface.onPageStart(getActivity(), getClass().getCanonicalName());
      //Log.i("fragment",getClass().getCanonicalName());
    } else {
      //Log.i("fragment",getClass().getCanonicalName());
      //JAnalyticsInterface.onPageStart(getActivity(), getClass().getCanonicalName());
    }
  }
}
