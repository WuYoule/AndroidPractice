package com.example.administrator.myanimfragment;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private FragmentManager mFragmentManager;
    private Button mAddButton;
    private Button mDeleteButton;

    private  Fragment mFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
     mAddButton= (Button) findViewById(R.id.add);
        mDeleteButton= (Button) findViewById(R.id.delete);
        mFragmentManager=getFragmentManager();

        mAddButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addFragment();
            }
        });

        mDeleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deleteFragment();
            }
        });
    }

    private void deleteFragment() {
        mFragmentManager.popBackStack();
    }

    private void addFragment() {

        mFragment=new MyFragment();
        FragmentTransaction fragmentTransaction=mFragmentManager.beginTransaction();
        //系统提供的标准动画
        fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_CLOSE);

        //自定义动画
        //fragmentTransaction.setCustomAnimations(...);需要动画资源文件



        fragmentTransaction.add(R.id.container,mFragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
}
