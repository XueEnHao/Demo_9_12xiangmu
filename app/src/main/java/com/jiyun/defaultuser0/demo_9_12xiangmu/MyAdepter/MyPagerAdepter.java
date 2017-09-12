package com.jiyun.defaultuser0.demo_9_12xiangmu.MyAdepter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import com.jiyun.defaultuser0.demo_9_12xiangmu.YindaoActivity;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/9/12.
 */

public class MyPagerAdepter extends PagerAdapter {
    private Context context;
    private ArrayList<View> list;
    public MyPagerAdepter(YindaoActivity yindaoActivity, ArrayList<View> viewlist) {
        this.context=yindaoActivity;
        this.list=viewlist;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view==object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        container.addView(list.get(position));
        return list.get(position);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
       container.removeView(list.get(position));
    }
}
