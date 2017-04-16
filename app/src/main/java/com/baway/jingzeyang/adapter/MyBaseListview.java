package com.baway.jingzeyang.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.baway.jingzeyang.R;
import com.baway.jingzeyang.bean.News;
import com.baway.jingzeyang.utils.Glideimageutils;

import java.util.List;

/**
 * Created by 荆泽阳 on 2017/3/25.
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

public class MyBaseListview extends BaseAdapter {
    private List<News> list;
    private Context context;

    public MyBaseListview(List<News> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder v = null;
        if (view == null) {
            view = View.inflate(context, R.layout.listviewitem, null);
            v = new ViewHolder();
            v.texttitle = (TextView) view.findViewById(R.id.title_one);
            v.textcontext = (TextView) view.findViewById(R.id.contect_thress);
            v.imager = (ImageView) view.findViewById(R.id.imageraaa);
            view.setTag(v);
        } else {
            v = (ViewHolder) view.getTag();
        }
        v.texttitle.setText(list.get(i).getTitle());
        v.textcontext.setText(list.get(i).getContent());
        Glideimageutils.Imagelode(context, list.get(i).getUrl(), v.imager);


        return view;
    }

    class ViewHolder {
        TextView texttitle, textcontext;
        ImageView imager;


    }

}
