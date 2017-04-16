package com.baway.jingzeyang.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.baway.jingzeyang.R;
import com.baway.jingzeyang.bean.Bean;
import com.baway.jingzeyang.bean.DataBean;
import com.baway.jingzeyang.utils.Glideimageutils;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import org.w3c.dom.Text;

import java.util.List;

/**
 * Created by 荆泽阳 on 2017/3/9.
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

public class XrecyclerViewAdaptertwo extends XRecyclerView.Adapter<XrecyclerViewAdaptertwo.MyViewHolder> {
    private List<DataBean.ResultBean> list;
    private Context context;
    private RecyOnItemClickListener recyOnItemClickListener;

    public XrecyclerViewAdaptertwo(List<DataBean.ResultBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    public void setRecyOnItemClickListener(RecyOnItemClickListener recyOnItemClickListener) {
        this.recyOnItemClickListener = recyOnItemClickListener;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        MyViewHolder myViewHolder = new MyViewHolder(View.inflate(context, R.layout.recycleritem, null));

        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        holder.text1.setText(list.get(position).title);
        holder.text2.setText(list.get(position).date);
        if (recyOnItemClickListener != null) {
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int layoutPosition = holder.getLayoutPosition();
                    recyOnItemClickListener.RecyItemClickListener(layoutPosition);
                }
            });
        }

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView text1,text2;


        public MyViewHolder(View v) {
            super(v);
            text1 = (TextView) v.findViewById(R.id.title_one);
            text2 = (TextView) v.findViewById(R.id.title_two);

        }
    }

    public interface RecyOnItemClickListener {
        void RecyItemClickListener(int pos);
    }
}
