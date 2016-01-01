package com.example.administrator.androidpractice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Adapter;

import com.example.adapter.MyAdapter;
import com.example.model.ItemObj;

public class MainActivity extends AppCompatActivity {
     private RecyclerView mRecyclerView;
    private RecyclerView.LayoutManager  mlayoutManager;

    private RecyclerView.Adapter<MyAdapter.ViewHolder> mAdapter;

    private ItemObj[] mDataSet=new ItemObj[100];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecyclerView= (RecyclerView) findViewById(R.id.recyler_view);

        //如果已知内容变化不会改变RecycerView的布局大小 使用这个设置来提高性能
        mRecyclerView.setHasFixedSize(true);

        mlayoutManager=new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mlayoutManager);

     for (int i=0;i<100;i++)
     {
         ItemObj itemObj=new ItemObj();
         itemObj.setText1("itemtext1--"+i);
         itemObj.setText2("itemtext2--"+i);
         mDataSet[i]=itemObj;

     }

        mAdapter =new MyAdapter(mDataSet);
        mRecyclerView.setAdapter(mAdapter);


    }
}
