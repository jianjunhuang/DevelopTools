package com.demo.jianjunhuang.mvptools.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import java.util.List;

/**
 * @author jianjunhuang.me@foxmail.com
 *         create on 2017/7/6.
 */

public class RecyclerAdapter<T> extends RecyclerView.Adapter<RecyclerViewHolder> {

    private List<T> list;

    public RecyclerAdapter(List<T> list){
        this.list = list;
    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
