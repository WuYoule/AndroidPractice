package com.example.administrator.mydrawerlayout;

import android.app.Fragment;
import android.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
     private DrawerLayout mDrawerLayout;
    private ListView mListView;
   public static ArrayList<String> mStrs;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mStrs=new ArrayList<String>();
        mStrs.add("tom");
        mStrs.add("marry");
        mStrs.add("jack");
        mDrawerLayout= (DrawerLayout) findViewById(R.id.drawer_layout);
        mListView= (ListView) findViewById(R.id.left_drawer);
        mListView.setAdapter(new ArrayAdapter<String>(this,R.layout.drawer_list_item,mStrs));
        mListView.setOnItemClickListener(new DrawerItemClickListener());

    }

    private class DrawerItemClickListener implements ListView.OnItemClickListener {

        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            selectItem(position);
        }
    }
    private void selectItem(int position) {
        Fragment fragment = new MyFragment();
        Bundle args = new Bundle();
        args.putInt(MyFragment.ITEM_NUMBER, position);
        fragment.setArguments(args);

        FragmentManager fragmentManager = getFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.content_frame, fragment)
                .commit();

        mListView.setItemChecked(position, true);
        mDrawerLayout.closeDrawer(mListView);
    }
    public static class MyFragment extends Fragment {
        public static final String ITEM_NUMBER = "item_number";



        public MyFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_item, container, false);
            int i = getArguments().getInt(ITEM_NUMBER);
            String itemName = mStrs.get(i);
            ((TextView) (rootView.findViewById(R.id.textview))).setText(itemName);
            return rootView;
        }
    }
}
