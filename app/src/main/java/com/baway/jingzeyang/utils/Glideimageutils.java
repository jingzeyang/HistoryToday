package com.baway.jingzeyang.utils;

import android.content.Context;
import android.util.TypedValue;
import android.widget.ImageView;

import com.baway.jingzeyang.R;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;

import jp.wasabeef.glide.transformations.CropCircleTransformation;

/**
 * 1.类的用途
 * 2.@author:jingzeyang
 * 3.@2017/3/16
 */


public class Glideimageutils {
    public static void Imagelode(Context context, String imageurl, ImageView imageView) {

//
        int width = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 200, context.getResources().getDisplayMetrics());
        int height = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 200f, context.getResources().getDisplayMetrics());
        Glide.with(context)
                .load(imageurl)
                .placeholder(R.mipmap.ic_launcher)//加载占位图
                .diskCacheStrategy(DiskCacheStrategy.SOURCE)//设置缓存
                .override(width,height)
                .dontAnimate()//加载五动画
                .centerCrop()
                .into(imageView);

    }
}
