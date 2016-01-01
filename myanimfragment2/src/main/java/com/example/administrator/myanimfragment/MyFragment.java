package com.example.administrator.myanimfragment;

import android.app.Fragment;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by Administrator on 2016/1/1.
 */
public class MyFragment extends Fragment {
    private  static int COUNT=0;
    private int mId=0;

    private  final int[] mColors=new int[]{Color.GREEN,Color.RED,Color.YELLOW,Color.BLUE,Color.GRAY};

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ++COUNT;
        mId=COUNT;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
      View view=inflater.inflate(R.layout.fragment,container,false);
        TextView textView= (TextView) view.findViewById(R.id.fragment_tv);
        LinearLayout linearLayout= (LinearLayout) view.findViewById(R.id.fragment_l);
        textView.setText("这是第" + mId + "个");
        linearLayout.setBackgroundColor(mColors[mId%mColors.length]);


        return  view;
    }
}
