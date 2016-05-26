package com.lavor.circleindicatordemo;

import android.graphics.Color;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;
import java.util.Random;

/**
 * Created by shitian on 2016-05-25.
 */
public class MyPagerAdapter2 extends PagerAdapter {
    private List<View> list;
    ViewPager viewPager;
    public MyPagerAdapter2(List<View> list) {
        this.list = list;
    }
    @Override public int getCount() {
        return list.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public void destroyItem(ViewGroup view, int position, Object object) {
        view.removeView(list.get(position));
    }

    @Override
    public Object instantiateItem(ViewGroup view, int position) {
        view.addView(list.get(position));
        return list.get(position);
    }

}