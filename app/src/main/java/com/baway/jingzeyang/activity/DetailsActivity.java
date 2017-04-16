package com.baway.jingzeyang.activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.baway.jingzeyang.R;
import com.baway.jingzeyang.bean.News;
import com.baway.jingzeyang.bean.XqBean;
import com.baway.jingzeyang.utils.Glideimageutils;
import com.baway.jingzeyang.utils.OkHttputils;
import com.baway.jingzeyang.utils.UrlUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 荆泽阳 on 2017/3/24.
 * 类的用途: 点击收藏按钮,存入数据库
 *
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

public class DetailsActivity extends AppCompatActivity {

    private FloatingActionButton mfab_like;
    public static List<Integer> listbb = new ArrayList<>();
    private Toolbar toolbar;
    private TextView textView;
    private ImageView imageView, backImager;
    private CollapsingToolbarLayout collToolBar;
    private List<XqBean.ResultBean> lista = new ArrayList<>();
    private int a = 1;
    private int b = 1;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.xiangqing);
        mfab_like = (FloatingActionButton) findViewById(R.id.fab_like);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        textView = (TextView) findViewById(R.id.xqtext);
        imageView = (ImageView) findViewById(R.id.backdrop);
        backImager = (ImageView) findViewById(R.id.backimager);
        collToolBar = (CollapsingToolbarLayout) findViewById(R.id.collToolBar);
        collToolBar.setExpandedTitleColor(Color.WHITE);
        collToolBar.setCollapsedTitleTextColor(Color.WHITE);
        Intent it = getIntent();
        String eid = it.getStringExtra("eid");
        initData(eid);
        backImager.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
    private void initData(String aa) {
        OkHttputils httputils = OkHttputils.getHttpUtils();
        httputils.loadDataFromNet(UrlUtils.XQ + aa, XqBean.class, new OkHttputils.CallBackListener<XqBean>() {
            @Override
            public void onSuccess(XqBean resulta) {
                List<XqBean.ResultBean> result1 = resulta.result;
                lista.addAll(result1);
                textView.setText(result1.get(0).content);
                toolbar.setTitle(result1.get(0).title);
                List<XqBean.ResultBean.PicUrlBean> picUrl = result1.get(0).picUrl;
                if (picUrl.size() <= 0) {
                    imageView.setBackgroundResource(R.drawable.welcome);
                    Toast.makeText(DetailsActivity.this, "暂时没有图片", Toast.LENGTH_SHORT).show();
                } else {
                    Glideimageutils.Imagelode(DetailsActivity.this, result1.get(0).picUrl.get(0).url, imageView);
                }
            }
            @Override
            public void onFail() {
            }
        });
    }

    public void Insert(View view) {
        if (a == 1) {
            a = 2;
            mfab_like.setSelected(true);
            News news = new News();
            news.setTitle(lista.get(0).title);
            news.setContent(lista.get(0).content);
            news.setUrl(lista.get(0).picUrl.get(0).url);
            news.save();
            if (news.save()) {
                listbb.add(b);
                b++;
            } else {

            }
        }
    }
}
