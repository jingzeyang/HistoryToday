package com.baway.jingzeyang.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.baway.jingzeyang.R;
import com.baway.jingzeyang.bean.Bean;
import com.baway.jingzeyang.utils.Glideimageutils;
import com.bumptech.glide.Glide;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

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

public class XrecyclerViewAdapter extends XRecyclerView.Adapter<XrecyclerViewAdapter.MyViewHolder> {
    private List<Bean.ResultsBean> list;
    private Context context;
    private RecyOnItemClickListener recyOnItemClickListener;

    public XrecyclerViewAdapter(List<Bean.ResultsBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    public void setRecyOnItemClickListener(RecyOnItemClickListener recyOnItemClickListener) {
        this.recyOnItemClickListener = recyOnItemClickListener;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        MyViewHolder myViewHolder = new MyViewHolder(View.inflate(context, R.layout.xrecycler, null));

        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        Glideimageutils.Imagelode(context,list.get(position).url,holder.imageView);
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
        ImageView imageView;


        public MyViewHolder(View v) {
            super(v);
            imageView = (ImageView) v.findViewById(R.id.ximager);


        }
    }
    public interface RecyOnItemClickListener {
        void RecyItemClickListener(int pos);
    }
}
