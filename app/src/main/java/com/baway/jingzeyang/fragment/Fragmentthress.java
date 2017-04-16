package com.baway.jingzeyang.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.baway.jingzeyang.R;
import com.baway.jingzeyang.activity.DetailsActivity;
import com.baway.jingzeyang.adapter.MyBaseListview;
import com.baway.jingzeyang.bean.News;

import org.litepal.crud.DataSupport;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 荆泽阳 on 2017/3/15.
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

public class Fragmentthress extends Fragment {
    private ListView listView;
    private List<News> list;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = View.inflate(getActivity(), R.layout.fragmentthress, null);
        listView = (ListView) view.findViewById(R.id.listviewa);
        list = new ArrayList<>();
        for (Integer a : DetailsActivity.listbb) {
            News news = DataSupport.find(News.class, (a));
            Log.i("news",news.toString());
            list.add(news);
        }
        MyBaseListview adapter = new MyBaseListview(list, getActivity());
        listView.setAdapter(adapter);
        return view;
    }
}
