package com.baway.jingzeyang.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.baway.jingzeyang.R;
import com.baway.jingzeyang.adapter.XrecyclerViewAdapter;
import com.baway.jingzeyang.bean.Bean;
import com.baway.jingzeyang.utils.OkHttputils;

import com.baway.jingzeyang.utils.UrlUtils;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

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

public class Fragmenttwo extends Fragment {
    private XRecyclerView xRecyclerView;
    private FloatingActionButton floatingActionButton;
    private View view;
    private String path;
    private XrecyclerViewAdapter viewAdapter;
    private List<Bean.ResultsBean> lista;
    private int page = 1;
    private GridLayoutManager gridLayoutManager;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = View.inflate(getActivity(), R.layout.fragmenttwo, null);
        intView();
        return view;
    }
    private void intView() {
        floatingActionButton = (FloatingActionButton) view.findViewById(R.id.floatingActionButton);
        xRecyclerView = (XRecyclerView) view.findViewById(R.id.xrecycler);
        gridLayoutManager = new GridLayoutManager(getActivity(), 2);
        xRecyclerView.setLayoutManager(gridLayoutManager);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               xRecyclerView.smoothScrollToPosition(0);
            }
        });
        xRecyclerView.setLoadingMoreEnabled(true);
        lista = new ArrayList<>();
        path = "20/1";
        getDate(1);
        xRecyclerView.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                path = "20/" + page;
                page++;
                getDate(2);
            }
            @Override
            public void onLoadMore() {
                path = "19/" + page;
                page++;
                getDate(3);
            }
        });
    }
    private void getDate(final int ll) {
        OkHttputils httputils = OkHttputils.getHttpUtils();
        httputils.loadDataFromNet(UrlUtils.url + path, Bean.class, new OkHttputils.CallBackListener<Bean>() {
            @Override
            public void onSuccess(Bean result) {
                if (ll == 1) {
                    List<Bean.ResultsBean> results = result.results;
                    lista.addAll(results);
                    viewAdapter = new XrecyclerViewAdapter(lista, getActivity());
                    xRecyclerView.setAdapter(viewAdapter);
                }
                if (ll == 2) {
                    lista.clear();
                    List<Bean.ResultsBean> results = result.results;
                    lista.addAll(results);
                    xRecyclerView.refreshComplete();
                    viewAdapter.notifyDataSetChanged();
                }
                if (ll == 3) {
                    List<Bean.ResultsBean> results = result.results;
                    lista.addAll(results);
                    xRecyclerView.loadMoreComplete();
                    viewAdapter.notifyDataSetChanged();
                }
                viewAdapter.setRecyOnItemClickListener(new XrecyclerViewAdapter.RecyOnItemClickListener() {
                    @Override
                    public void RecyItemClickListener(int pos) {
                        Intent it = new Intent(getActivity(), PhotoActivity.class);
                        Log.i("TAG", pos + "");
                        it.putExtra("url", lista.get(pos - 1).url);
                        it.putExtra("id",pos+1);
                        startActivity(it);
                    }
                });
            }
            @Override
            public void onFail() {
            }
        });

    }
}
