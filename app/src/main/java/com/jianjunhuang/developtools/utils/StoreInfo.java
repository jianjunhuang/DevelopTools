package com.jianjunhuang.developtools.utils;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * 对 SharedPerferences 轻度封装
 * <br>
 * 1.在 Application 中 init
 * 2.调用时 StoreInfo.instanec().store()
 * @author jianjunhuang.me@foxmail.com
 * @since 2017/2/10.
 */

public class StoreInfo {
    private Context context;
    private SharedPreferences sp;
    private static StoreInfo storeInfo;
    private String fileName = "store_info";

    private StoreInfo(Context context) {
        this.context = context;
    }

    /**
     * 初始化
     * @param context
     * @return
     */
    public static StoreInfo init(Context context) {
        if (storeInfo == null) {
            synchronized (StoreInfo.class) {
                if (storeInfo == null) {
                    storeInfo = new StoreInfo(context);
                }
            }
        }
        return storeInfo;
    }

    /**
     * 获取实例
     * @return
     */
    public static StoreInfo instance() {
        if (storeInfo == null) {
            new RuntimeException("did'nt init before use");
        }
        return storeInfo;
    }

    /**
     * 设置存储文件的名称
     * @param fileName
     */
    public void setFileName(String fileName){
        this.fileName = fileName;
    }

    /**
     * 获取存储文件的名称
     * @param fileName
     * @return
     */
    public String getFileName(String fileName){
        return fileName;
    }


    /**
     * @param key
     * @param value
     */
    private void storeInside(String key, Object value) {
        sp = context.getSharedPreferences(fileName, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        if (value instanceof Integer) {
            editor.putInt(key, (Integer) value);
        } else if (value instanceof Long) {
            editor.putLong(key, (Long) value);
        } else if (value instanceof Boolean) {
            editor.putBoolean(key, (Boolean) value);
        } else if (value instanceof Float) {
            editor.putFloat(key, (Float) value);
        } else if (value instanceof String) {
            editor.putString(key, (String) value);
        }
        editor.commit();
    }

    /**
     * @param key
     * @param value
     * @return
     */
    private Object getInfoInside(String key, Object value) {
        sp = context.getSharedPreferences(fileName, Context.MODE_PRIVATE);
        if (value instanceof Integer) {
            return sp.getInt(key, (Integer) value);
        } else if (value instanceof Long) {
            return sp.getLong(key, (Long) value);
        } else if (value instanceof Boolean) {
            return sp.getBoolean(key, (Boolean) value);
        } else if (value instanceof Float) {
            return sp.getFloat(key, (Float) value);
        } else if (value instanceof String) {
            return sp.getString(key, (String) value);
        } else {
            return null;
        }
    }

    /**
     * @param key
     * @param value
     */
    public void store(String key, String value) {
        storeInside(key, value);
    }

    /**
     * @param key
     * @param value
     */
    public void store(String key, int value) {
        storeInside(key, value);
    }

    /**
     * @param key
     * @param value
     */
    public void store(String key, boolean value) {
        storeInside(key, value);
    }

    /**
     * @param key
     * @param value
     */
    public void store(String key, float value) {
        storeInside(key, value);
    }

    /**
     * @param key
     * @param value
     */
    public void store(String key, long value) {
        storeInside(key, value);
    }

    /**
     * @param key
     * @param defaultBack
     * @return
     */
    public String getInfo(String key, String defaultBack) {
        return (String) getInfoInside(key, defaultBack);
    }

    /**
     * @param key
     * @param defaultBack
     * @return
     */
    public int getInfo(String key, int defaultBack) {
        return (Integer) getInfoInside(key, defaultBack);
    }

    /**
     * @param key
     * @param defaultBack
     * @return
     */
    public float getInfo(String key, float defaultBack) {
        return (Float) getInfoInside(key, defaultBack);
    }

    /**
     * @param key
     * @param defaultBack
     * @return
     */
    public boolean getInfo(String key, boolean defaultBack) {
        return (Boolean) getInfoInside(key, defaultBack);
    }

    /**
     * @param key
     * @param defaultBack
     * @return
     */
    public long getInfo(String key, long defaultBack) {
        return (Long) getInfoInside(key, defaultBack);
    }

    public void clearAll() {
        sp = context.getSharedPreferences(fileName, Context.MODE_PRIVATE);
        sp.edit().clear().commit();
    }

    public void clear(String name) {
        sp = context.getSharedPreferences(fileName, Context.MODE_PRIVATE);
        sp.edit().remove(name).commit();
    }
}
