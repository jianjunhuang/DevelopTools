package com.jianjunhuang.developtools.framework;

import android.content.Context;
import android.widget.Toast;

/**
 *
 * 对 Toast 的简单封装
 * 采用的是全局的 context ，所以要在 Application 中进行初始化，传入全局的 context。
 * 避免了静态的 Toast 一直持有 Activity 的引用，造成内存泄漏
 * @author jianjunhuang.me@foxmail.com
 * @since 2017/2/10.
 */

public class BaseToast {
    private static BaseToast baseToast = null;
    private static Context context;
    private static Toast toast;

    private BaseToast(Context context){
        this.context = context;
        if(toast == null){
            toast = Toast.makeText(context,"",Toast.LENGTH_SHORT);
        }
    }

    /**
     * 在 Application 中初始化
     * @param context Application's context
     */
    public static void init(Context context){
        if(baseToast == null){
            synchronized (BaseToast.class){
                if(baseToast == null){
                    baseToast = new BaseToast(context);
                }
            }
        }
    }

    private static void show(String msg,int time){
        if(context == null){
            try {
                throw new Exception("context did'nt init");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        toast.setText(msg);
        toast.setDuration(time);
        toast.show();
    }

    public static void showShort(String msg){
        show(msg,Toast.LENGTH_SHORT);
    }

    public static void showLong(String msg){
        show(msg,Toast.LENGTH_LONG);
    }

    public static void showShort(int msg){
        show(context.getString(msg),Toast.LENGTH_SHORT);
    }

    public static void showLong(int msg){
        show(context.getString(msg),Toast.LENGTH_LONG);
    }
}
