package com.example.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.administrator.androidpractice.R;
import com.example.model.ItemObj;

/**
 * Created by Administrator on 2016/1/1.
 */
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    private ItemObj[] mDataSet;

    public  MyAdapter(ItemObj[] mDataSet){

        this.mDataSet=mDataSet;


    }
    public static class  ViewHolder extends  RecyclerView.ViewHolder{
        public TextView textView1;
        public TextView textView2;

        public ViewHolder(View itemView) {
            super(itemView);
            textView1= (TextView) itemView.findViewById(R.id.text1);
            textView2= (TextView) itemView.findViewById(R.id.text2);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView= LayoutInflater.from(parent.getContext()).inflate(R.layout.recyler_itme,parent,false);
        ViewHolder viewHolder=new ViewHolder(itemView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.textView1.setText(mDataSet[position].getText1());
        holder.textView2.setText(mDataSet[position].getText2());
    }

    @Override
    public int getItemCount() {
        return mDataSet.length;
    }








}
