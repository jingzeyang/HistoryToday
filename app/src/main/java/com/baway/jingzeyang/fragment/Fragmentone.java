package com.baway.jingzeyang.fragment;

import android.content.Intent;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.text.format.Time;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.baway.jingzeyang.R;
import com.baway.jingzeyang.activity.RiliActivity;
import com.baway.jingzeyang.activity.DetailsActivity;
import com.baway.jingzeyang.adapter.XrecyclerViewAdaptertwo;
import com.baway.jingzeyang.bean.DataBean;
import com.baway.jingzeyang.utils.MyApp;
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

public class Fragmentone extends Fragment {
    private FloatingActionButton aa;
    public static int a = 1;
    private TextView texttime, texttime2, texttime3, textqian, texthou;
    private View view;
    private int day;
    private int month;
    private int year;
    private XRecyclerView xRecyclerView;
    private List<DataBean.ResultBean> lista = new ArrayList<>();
    private XrecyclerViewAdaptertwo xrecyclerViewAdaptertwo;
    private String u;
    private char resulta;
    private char result;
    private int montha;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = View.inflate(getActivity(), R.layout.fragmentone, null);
        MyApp.context = getActivity();
        texttime = (TextView) view.findViewById(R.id.shijian);
        texttime2 = (TextView) view.findViewById(R.id.shijian1);
        texttime3 = (TextView) view.findViewById(R.id.shijian2);
        textqian = (TextView) view.findViewById(R.id.textqian);
        texthou = (TextView) view.findViewById(R.id.texthou);
        xRecyclerView = (XRecyclerView) view.findViewById(R.id.XRecyclerViewOne);
        xRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        aa = (FloatingActionButton) view.findViewById(R.id.floatingActionButtonaa);
        initView();


        return view;
    }

    private void initView() {


        if (a == 1) {
            Time t = new Time(); // or Time t=new Time("GMT+8"); 加上Time Zone资料
            t.setToNow(); // 取得系统时间。
            year = t.year;
            month = t.month;
            day = t.monthDay;
            montha = month + 1;
            texttime.setText(year + "");
            texttime2.setText(montha + "");
            texttime3.setText(day + "");
            String s = UrlUtils.hisurl + montha + "/" + day;
            getDate(s);
        }
        if (a == 2) {
            Intent it = getActivity().getIntent();
            String mes = it.getStringExtra("mes");
            String[] temp = null;
            temp = mes.split("-");
            result = temp[1].charAt(1);
            if (Integer.parseInt(temp[2]) < 10 && Integer.parseInt(temp[1]) < 10) {
                resulta = temp[2].charAt(1);
                result = temp[1].charAt(1);
                texttime.setText(temp[0] + "");
                texttime2.setText(result + "");
                texttime3.setText(resulta + "");
                u = UrlUtils.hisurl + result + "/" + resulta;
            } else {
                u = UrlUtils.hisurl + result + "/" + temp[2];
                texttime.setText(temp[0] + "");
                texttime2.setText(result + "");
                texttime3.setText(temp[2] + "");
            }
            getDate(u);
        }
        textqian.setOnClickListener(new View.OnClickListener() {
            private int i;
            @Override
            public void onClick(View view) {
                if (a == 1) {
                    if (montha == 3) {
                        day--;
                        if (day < 1) {
                            if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
                                //闰年
                                day = 29;
                                montha--;
                            } else {
                                //平年
                                day = 28;
                                montha--;
                            }
                        }
                    } else if (montha == 1) {
                        day--;
                        if (day < 1) {
                            day = 31;
                            montha = 12;
                            year--;
                        }
                    } else if (montha == 2 || montha == 4 || montha == 6 || montha == 8 || montha == 9 || montha == 11) {
                        day--;
                        if (day < 1) {
                            day = 31;
                            montha--;
                        }
                    } else {
                        day--;
                        if (day < 1) {
                            day = 30;
                            montha--;
                        }
                    }
                    String aa = UrlUtils.hisurl + montha + "/" + day;
                    texttime3.setText(day + "");
                    texttime.setText(year + "");
                    texttime2.setText(montha + "");
                    getDate(aa);
                    xrecyclerViewAdaptertwo.notifyDataSetChanged();
                } else {
                    String trim = texttime.getText().toString().trim();
                    String trim1 = texttime2.getText().toString().trim();
                    String trim2 = texttime3.getText().toString().trim();
                    int bbb1 = Integer.parseInt(trim);
                    int bbb2 = Integer.parseInt(trim1);
                    int bbb3 = Integer.parseInt(trim2);
                    if (bbb2 == 3) {
                        bbb3--;
                        if (bbb3 < 1) {
                            if ((bbb1 % 4 == 0 && bbb1 % 100 != 0) || bbb1 % 400 == 0) {
                                //闰年
                                bbb3 = 29;
                                bbb2--;
                            } else {
                                //平年
                                bbb3 = 28;
                                bbb2--;
                            }
                        }
                    } else if (bbb2 == 1) {
                        bbb3--;
                        if (bbb3 < 1) {
                            bbb3 = 31;
                            bbb2 = 12;
                            bbb1--;
                        }
                    } else if (bbb2 == 2 || bbb2 == 4 || bbb2 == 6 || bbb2 == 8 || bbb2 == 9 || bbb2 == 11) {
                        bbb3--;
                        if (bbb3 < 1) {
                            bbb3 = 31;
                            bbb2--;
                        }
                    } else {
                        bbb3--;
                        if (bbb3 < 1) {
                            bbb3 = 30;
                            bbb2--;
                        }
                    }
                    texttime3.setText(bbb3 + "");
                    texttime.setText(bbb1 + "");
                    texttime2.setText(bbb2 + "");
                    String aa = UrlUtils.hisurl + bbb2 + "/" + bbb3;
                    getDate(aa);
                    xrecyclerViewAdaptertwo.notifyDataSetChanged();
                }
            }
        });
        texthou.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (a == 1) {
                    if (montha == 2) {
                        //二月
                        if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
                            //闰年
                            day++;
                            if (day > 29) {
                                day = 1;
                                montha++;
                            }

                        } else {
                            //平年
                            day++;
                            if (day > 28) {
                                day = 1;
                                montha++;
                            }
                        }

                    } else if (montha == 1 || montha == 3 || montha == 5 || montha == 6 || montha == 8 || montha == 10) {
                        //大月
                        day++;
                        if (day > 31) {
                            day = 1;
                            montha++;
                        }


                    } else if (montha == 12) {
                        day++;
                        if (day > 31) {
                            day = 1;
                            montha = 1;
                            year++;

                        }

                    } else {
                        //小月
                        day++;
                        if (day > 30) {
                            day = 1;
                            montha++;

                        }
                    }
                    String aa = UrlUtils.hisurl + (month + 1) + "/" + day;
                    texttime3.setText(day + "");
                    texttime2.setText(montha + "");
                    texttime.setText(year + "");
                    getDate(aa);
                    xrecyclerViewAdaptertwo.notifyDataSetChanged();
                } else {
                    String trim = texttime.getText().toString().trim();
                    String trim1 = texttime2.getText().toString().trim();
                    String trim2 = texttime3.getText().toString().trim();
                    int bbb1 = Integer.parseInt(trim);
                    int bbb2 = Integer.parseInt(trim1);
                    int bbb3 = Integer.parseInt(trim2);
                    if (bbb2 == 2) {
                        //二月
                        if ((bbb2 % 4 == 0 && bbb2 % 100 != 0) || bbb2 % 400 == 0) {
                            //闰年
                            bbb3++;
                            if (bbb3 > 29) {
                                bbb3 = 1;
                                bbb2++;
                            }
                        } else {
                            //平年
                            bbb3++;
                            if (bbb3 > 28) {
                                bbb3 = 1;
                                bbb2++;
                            }
                        }
                    } else if (bbb2 == 1 || bbb2 == 3 || bbb2 == 5 || bbb2 == 6 || bbb2 == 8 || bbb2 == 10) {
                        //大月
                        bbb3++;
                        if (bbb3 > 31) {
                            bbb3 = 1;
                            bbb2++;
                        }
                    } else if (bbb2 == 12) {
                        bbb3++;
                        if (bbb3 > 31) {
                            bbb3 = 1;
                            bbb2 = 1;
                            bbb1++;
                        }
                    } else {
                        //小月
                        bbb3++;
                        if (bbb3 > 30) {
                            bbb3 = 1;
                            bbb2++;
                        }
                    }
                    texttime3.setText(bbb3 + "");
                    texttime2.setText(bbb2 + "");
                    texttime.setText(bbb1 + "");
                    String aa = UrlUtils.hisurl + bbb2 + "/" + bbb3;
                    getDate(aa);
                    xrecyclerViewAdaptertwo.notifyDataSetChanged();
                }
            }
        });
        aa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(getActivity(), RiliActivity.class);
                a = 2;
                startActivity(it);
                getActivity().finish();
            }
        });
    }
    private void getDate(String url) {
        OkHttputils httputils = OkHttputils.getHttpUtils();
        httputils.loadDataFromNet(url, DataBean.class, new OkHttputils.CallBackListener<DataBean>() {
            @Override
            public void onSuccess(DataBean result1) {
                if (a == 1) {
                    lista = result1.result;
                    xrecyclerViewAdaptertwo = new XrecyclerViewAdaptertwo(lista, getActivity());
                    xRecyclerView.setAdapter(xrecyclerViewAdaptertwo);
                } else {
                    lista.clear();
                    lista = result1.result;
                    xrecyclerViewAdaptertwo = new XrecyclerViewAdaptertwo(lista, getActivity());
                    xRecyclerView.setAdapter(xrecyclerViewAdaptertwo);
                }
                xrecyclerViewAdaptertwo.setRecyOnItemClickListener(new XrecyclerViewAdaptertwo.RecyOnItemClickListener() {
                    @Override
                    public void RecyItemClickListener(int pos) {
                        String e_id = lista.get(pos-1).e_id;
                        Intent it=new Intent(getActivity(), DetailsActivity.class);
                        Log.i("lkj",e_id);
                        it.putExtra("eid",e_id);
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