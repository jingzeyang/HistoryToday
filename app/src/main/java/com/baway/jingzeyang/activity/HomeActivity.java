package com.baway.jingzeyang.activity;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;


import com.baway.jingzeyang.R;
import com.baway.jingzeyang.adapter.MyBaseAdapter;
import com.baway.jingzeyang.fragment.Fragmentfour;
import com.baway.jingzeyang.fragment.Fragmentone;
import com.baway.jingzeyang.fragment.Fragmentthress;
import com.baway.jingzeyang.fragment.Fragmenttwo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 荆泽阳 on 2017/3/15.
 * 主页面
 * .::::.
 * .::::::::.
 * :::::::::::  Goddess bless, never bug
 * ..:::::::::::'
 * '::::::::::::'
 * .::::::::::
 * '::::::::::::::..
 * ..::::::::::::.
 * ``::::::::::::::::
 * ::::``:::::::::'        .:::.
 * ::::'   ':::::'       .::::::::.
 * .::::'      ::::     .:::::::'::::.
 * .:::'       :::::  .:::::::::' ':::::.
 * .::'        :::::.:::::::::'      ':::::.
 * .::'         ::::::::::::::'         ``::::.
 * ...:::           ::::::::::::'              ``::.
 * ```` ':.          ':::::::::'                  ::::..
 * '.:::::'                    ':'````..
 */

public class HomeActivity extends AppCompatActivity {
    private DrawerLayout mdrawerLayout;
    private ImageView mimager;
    private TextView mtextView;
    private ListView mlistview;
    private Fragmentone one;
    private Fragmenttwo two;
    private Fragmentthress thress;
    private Fragmentfour four;
    private FragmentTransaction transaction;
    private FragmentManager manager;
    private List<Integer> list;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_yemian);
        initView();
    }
    private void initView() {
        mimager = (ImageView) findViewById(R.id.dian);
        mdrawerLayout = (DrawerLayout) findViewById(R.id.v4_drawerlayout);
        mtextView = (TextView) findViewById(R.id.textaa);
        mlistview = (ListView) findViewById(R.id.listviewa);
        initDate();
    }
    private void initDate() {
        one = new Fragmentone();
        two = new Fragmenttwo();
        thress = new Fragmentthress();
        four = new Fragmentfour();
        list = new ArrayList<>();
        list.add(R.drawable.lishi);
        list.add(R.drawable.mei);
        list.add(R.drawable.shou);
        list.add(R.drawable.guan);
        MyBaseAdapter myBaseAdapter = new MyBaseAdapter(HomeActivity.this, list);
        mlistview.setAdapter(myBaseAdapter);
        manager = getSupportFragmentManager();
        transaction = manager.beginTransaction();
        transaction.add(R.id.v4_drawerlayout_frame, one);
        transaction.commit();
        mdrawerLayout.closeDrawer(Gravity.LEFT);
        mlistview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                View childAt = adapterView.getChildAt(0);
                View childAt1 = adapterView.getChildAt(1);
                View childAt2 = adapterView.getChildAt(2);
                View childAt3 = adapterView.getChildAt(3);
                switch (i) {
                    case 0:
                        childAt.setEnabled(true);
                        childAt1.setEnabled(false);
                        childAt2.setEnabled(false);
                        childAt3.setEnabled(false);
                        transaction = manager.beginTransaction();
                        transaction.replace(R.id.v4_drawerlayout_frame, one);
                        transaction.commit();
                        break;
                    case 1:
                        mtextView.setText("妹纸");
                        childAt.setEnabled(false);
                        childAt1.setEnabled(true);
                        childAt2.setEnabled(false);
                        childAt3.setEnabled(false);
                        transaction = manager.beginTransaction();
                        transaction.replace(R.id.v4_drawerlayout_frame, two);
                        transaction.commit();
                        break;
                    case 2:
                        mtextView.setText("收藏");
                        childAt.setEnabled(false);
                        childAt1.setEnabled(false);
                        childAt2.setEnabled(true);
                        childAt3.setEnabled(false);
                        transaction = manager.beginTransaction();
                        transaction.replace(R.id.v4_drawerlayout_frame, thress);
                        transaction.commit();
                        break;
                    case 3:
                        mtextView.setText("关于");
                        childAt.setEnabled(false);
                        childAt1.setEnabled(false);
                        childAt2.setEnabled(false);
                        childAt3.setEnabled(true);
                        transaction = manager.beginTransaction();
                        transaction.replace(R.id.v4_drawerlayout_frame, four);
                        transaction.commit();
                        break;
                }
                mdrawerLayout.closeDrawer(Gravity.LEFT);
            }
        });
        mimager.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mdrawerLayout.openDrawer(Gravity.LEFT);
            }
        });
    }

//    private void showDrawerLayout() {
//        if (!drawerLayout.isDrawerOpen(Gravity.LEFT)) {
//            mdrawerLayout.openDrawer(Gravity.LEFT);
//        } else {
//            mdrawerLayout.closeDrawer(Gravity.LEFT);
//        }
//    }
}


